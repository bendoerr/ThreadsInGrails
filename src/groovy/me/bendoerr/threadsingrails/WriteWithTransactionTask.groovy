package me.bendoerr.threadsingrails

class WriteWithTransactionTask implements Runnable {
    void run() {
        Cog.withTransaction {
            Cog.list().each {
                it.name = "AsyncWithTransaction"
                it.save(failOnError: true, flush: true)
            }
        }
    }

}
