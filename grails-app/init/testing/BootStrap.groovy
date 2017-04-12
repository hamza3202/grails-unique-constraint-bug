package testing

import grails.core.GrailsApplication

class BootStrap {
    def dataSource
    def abcService
    GrailsApplication grailsApplication
    def init = { servletContext ->
        println("here")
    }
    def destroy = {
    }
}
