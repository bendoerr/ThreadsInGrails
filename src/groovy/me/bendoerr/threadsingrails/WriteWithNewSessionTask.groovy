package me.bendoerr.threadsingrails

class WriteWithNewSessionTask implements Runnable {
    void run() {
        Cog.withNewSession {
            Cog.list().each {
                it.name = "AsyncWithSession"
                it.save(failOnError: true, flush: true)
            }
        }
    }

}
