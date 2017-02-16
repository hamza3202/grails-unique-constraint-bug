package testing

class Abc {

    String temp

    static constraints = {
        temp unique: true
    }

    static mapping = {
        datasource('ALL')
    }
}
