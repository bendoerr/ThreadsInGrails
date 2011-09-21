package me.bendoerr.threadsingrails

class ReadTask implements Runnable {
    void run() {
        Cog.list().each {
            println it.name
        }
    }

}
