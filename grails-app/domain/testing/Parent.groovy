package testing

import groovy.transform.ToString

@ToString(includeNames=true)
class Parent extends Base {

    static hasMany = [child: Child]
    static constraints = {
    }
    static mapping = {
        datasource('ALL')
    }

}
