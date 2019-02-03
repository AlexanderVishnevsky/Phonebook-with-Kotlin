package phonebook.Model

class Fio {
    var name: String? = null
    var middleName: String? = null
    var lastName: String? = null

    fun printFio() {
        println("Fio: $lastName $name $middleName")
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val fio = o as Fio?

        if (name != fio!!.name) return false
        return if (middleName != fio.middleName) false else lastName == fio.lastName

    }

    override fun hashCode(): Int {
        var result = name!!.hashCode()
        result = 31 * result + middleName!!.hashCode()
        result = 31 * result + lastName!!.hashCode()
        return result
    }
}