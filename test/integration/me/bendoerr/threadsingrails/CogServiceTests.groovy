package me.bendoerr.threadsingrails

import grails.test.*

class CogServiceTests extends GroovyTestCase {
    CogService cogService

    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testReadAsync() {
        def handler = cogService.readAsync()
        if (handler.e) throw handler.e
    }

    void testWriteAsyncNothingExtra() {
        def handler = cogService.writeAsyncNoTrans()
        assert handler.e instanceof org.hibernate.HibernateException
    }

    void testWriteAsyncWithTransaction() {
        def handler = cogService.writeAsyncWithTransaction()
        if (handler.e) throw handler.e
    }

    void testWriteAsyncWithNewSession() {
        def handler = cogService.writeAsyncWithTransaction()
        if (handler.e) throw handler.e
    }

    void testWriteAsyncWithExecutorWithTransaction() {
        cogService.writeAsyncWithExecutorWithTransaction()
    }
}
