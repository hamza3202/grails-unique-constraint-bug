package testing

import grails.transaction.Transactional

@Transactional
class PublicIdGenerationService {

    String generatePublicId(Class clazz) {
        String newId = ""
        boolean isGenerated = false
        clazz.withNewSession {
            while (!isGenerated) {
                newId = generateId()

                if (clazz.countByPublicId(newId, [cache: true]) == 0) {
                    isGenerated = true
                }
            }
        }
        return newId
    }

    Abc getAbc(){
        Abc.createCriteria().get {
            idEq(1L)
        } as Abc
    }
}
