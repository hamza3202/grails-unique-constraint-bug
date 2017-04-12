package testing

class Child extends Base {

    PaymentMethod temp

    static constraints = {

    }

    static belongsTo = [parent : Parent]

    static mapping = {
        datasource('ALL')
    }

    enum PaymentMethod {
        CREDIT_CARD("CREDIT_CARD"), INVOICE("INVOICE")
        String value

        PaymentMethod(){}
        PaymentMethod(String value) {
            this.value = value
        }

        String toString() {
            value
        }

        String getKey() {
            name()
        }
    }
}
