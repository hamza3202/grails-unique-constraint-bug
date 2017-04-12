package testing

import grails.transaction.Transactional
import org.apache.commons.lang.RandomStringUtils

@Transactional
class AbcService {
    PublicIdGenerationService publicIdGenerationService

    def serviceMethod() {
        Abc abc = Abc.findById(1L)
        log.info("should be locked")
        abc.name= RandomStringUtils.randomAlphanumeric(10)
        Random generator = new Random();
        int i = generator.nextInt(10000)+100;
        Thread.currentThread().sleep((long)(0.3*i));
        log.info("should be unlocked")
        abc.save()
    }

    def doInsertionSortOnCameraData(time){
        int temp;
        int loopCount=0
        for (int i = 1; i < time.size(); i++) {
            for(int j = i ; j > 0 ; j--){
                loopCount++
                if(time[j] < time[j-1]){
                    temp = time[j];
                    time[j] = time[j-1];
                    time[j-1] = temp;

                }
                else{
                    break;
                }
            }
        }
        log.info("$loopCount\n$time")
        return time;
    }

}
