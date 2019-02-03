package phonebook.Model

class Phone {
    var countryCode: String? = null
    var operatorCode: String? = null
    var phoneNumber: String? = null

    fun printPhone() {
        println("Phone: $countryCode($operatorCode)$phoneNumber")
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val phone = o as Phone?

        if (countryCode != phone!!.countryCode) return false
        return if (operatorCode != phone.operatorCode) false else phoneNumber == phone.phoneNumber

    }

    override fun hashCode(): Int {
        var result = countryCode!!.hashCode()
        result = 31 * result + operatorCode!!.hashCode()
        result = 31 * result + phoneNumber!!.hashCode()
        return result
    }
}
