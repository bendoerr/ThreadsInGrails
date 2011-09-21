import me.bendoerr.threadsingrails.*

class BootStrap {

    def init = { servletContext ->
		new Cog(name: "Initial 1").save(failOnError: true)
		new Cog(name: "Second").save(failOnError: true)
    }
    def destroy = {
    }
}
