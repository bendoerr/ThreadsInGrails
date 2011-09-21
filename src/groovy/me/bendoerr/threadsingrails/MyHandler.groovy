package me.bendoerr.threadsingrails


class MyHandler implements Thread.UncaughtExceptionHandler {
    Throwable e
    Thread t

    void uncaughtException(Thread t, Throwable e) {
        this.e = e
        this.t = t
    }
}
