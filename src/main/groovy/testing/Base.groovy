package testing
/**
 * Created by hamza on 3/6/17.
 */

abstract class  Base implements Serializable{
    def publicIdGenerationService
    static transients = ['publicIdGenerationService']

    static constraints = {

    }

    String publicId

    def beforeInsert() {
        insertPublicIdIfNeeded()
    }

    def insertPublicIdIfNeeded(){
        if (!publicId) {
            publicId = publicIdGenerationService.generatePublicId(getClass())
        }
    }
}
