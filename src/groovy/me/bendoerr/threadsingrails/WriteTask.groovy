package me.bendoerr.threadsingrails

class WriteTask implements Runnable {
    void run() {
        Cog.list().each {
            it.name = "Foobar"
            it.save(failOnError: true)
        }
    }

}
