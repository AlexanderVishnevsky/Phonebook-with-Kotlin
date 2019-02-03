package phonebook.Actions

import phonebook.Model.Fio
import phonebook.Model.Phone
import java.io.IOException
import java.util.regex.Matcher
import java.util.regex.Pattern

object Mask {

    //mask for fio
    private val fioPattern = Pattern.compile("(([A-Z,a-z])([A-Z,a-z]{1,60})(\\s)([A-Z,a-z])([A-Z,a-z]{1,60})(\\s)([A-Z,a-z])([A-Z,a-z]{1,60}))$")
    //mask for phone number 80(..)... or +375(..)...
    private val phonePattern = Pattern.compile("(80|\\+375)(\\(?(\\d{2})\\)?(\\d{7}))$")

    fun checkFio(): Fio {
        val fio = Fio()
        try {
            do {
                println("\n" + "Enter Full Name throw spaces like:\n" + "LastName Name MiddleName\n")

                //mask for Fio
                val matcher: Matcher = fioPattern.matcher(ConsoleReader.readFromConsole())
                if (matcher.matches()) {
                    fio.lastName = matcher.group(2).toUpperCase() + matcher.group(3).toLowerCase()
                    fio.name = matcher.group(5).toUpperCase() + matcher.group(6).toLowerCase()
                    fio.middleName = matcher.group(8).toUpperCase() + matcher.group(9).toLowerCase()
                }
            } while (fio.lastName == null)
        } catch (e: IOException) {
            println("Wrong fio$e")
        }

        return fio
    }

    fun checkPhone(): Phone {
        val phone = Phone()
        try {
            do {
                println("\n" + "Enter phone like 80(29).. or +375(29)...")

                val m: Matcher = phonePattern.matcher(ConsoleReader.readFromConsole())
                if (m.matches()) {
                    phone.countryCode = m.group(1)
                    phone.operatorCode = m.group(3)
                    phone.phoneNumber = m.group(4)
                }
            } while (phone.phoneNumber == null)
        } catch (e: IOException) {
            println("Wrong phone$e")
        }

        return phone
    }


}
