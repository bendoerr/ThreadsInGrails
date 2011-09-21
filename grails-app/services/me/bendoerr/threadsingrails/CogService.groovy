package me.bendoerr.threadsingrails

import java.util.concurrent.Executors

class CogService {

    def executor = Executors.newSingleThreadExecutor()

    static transactional = true
	
	def doWithThread(Runnable r) {
		def t = new Thread(r)
        def handler = new MyHandler()
		t.setUncaughtExceptionHandler(handler)
		t.start()
		while(t.isAlive()) {}
		return handler
	}
	
    def readAsync() {
		doWithThread(new ReadTask())
    }
	
	def writeAsyncNoTrans() {
		doWithThread(new WriteTask())
	}
	
	def writeAsyncWithTransaction() {
		doWithThread(new WriteWithTransactionTask())
	}
	
	def writeAsyncWithNewSession() {
		doWithThread(new WriteWithNewSessionTask())
	}

    def writeAsyncWithExecutorWithTransaction() {
        executor.execute({
            try {
                new WriteWithTransactionTask().run()
            } catch (Exception e) {
                e.printStackTrace()
                throw e
            }
        })
    }
}
