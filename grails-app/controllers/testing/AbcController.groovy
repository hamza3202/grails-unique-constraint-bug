package testing

import grails.async.Promise
import grails.converters.JSON
import grails.http.client.AsyncHttpBuilder
import grails.http.client.HttpClientResponse
import org.hibernate.SessionFactory

class AbcController {
    static abc

    SessionFactory sessionFactory

    def index() {
        Abc abc = new Abc(temp: "testing")
        abc.save()

        Abc abc1 = new Abc(temp: "testing")
        Abc.second.withNewSession{
            abc1.second.save()
        }
        def response = [Errors:abc1.errors]
        render  response as JSON
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
            Abc.withTransaction {
                println(Abc.count())
            }
            println("here")
        }

        def response = [title:"OK"]
        render  response as JSON
    }
}
