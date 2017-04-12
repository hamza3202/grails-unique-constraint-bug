package testing

import grails.async.Promise
import grails.converters.JSON
import grails.http.client.AsyncHttpBuilder
import grails.http.client.HttpClientResponse
import org.apache.commons.lang.RandomStringUtils
import org.hibernate.SessionFactory

class AbcController {
    static abc
    AbcService abcService
    SessionFactory sessionFactory

    def index() {
        //new Abc(name:"sdad").save()
        abcService.doInsertionSortOnCameraData([1,2,3,4,6,5,7,8,9,10])
    }

    def test(){
        AsyncHttpBuilder client = new AsyncHttpBuilder()
        def abc
        println("call sent")
        Promise<HttpClientResponse> p = client.post("http://localhost:8081/abc/index") {
            contentType 'application/json'
            json {
                title "Hello World"
            }
        }
        p.onComplete { HttpClientResponse resp ->
            abc = resp.json
            Child.withTransaction {
                println(Child.count())
            }
            println("here")
        }

        def response = [title:"OK"]
        render  response as JSON
    }

    def test1(){

    }

    def test2(){
        Abc abc = Abc.findById(1L)
        log.info("should be locked")
        abc.name= RandomStringUtils.randomAlphanumeric(10)
        Random generator = new Random();
        int i = generator.nextInt(10000)+100;
        Thread.currentThread().sleep((long)(0.3*i));
        log.info("should be unlocked")
        abc.save()
        def responseJSON = [message : "here"]
        render responseJSON as JSON
    }
}
