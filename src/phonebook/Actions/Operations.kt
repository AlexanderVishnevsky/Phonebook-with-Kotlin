package phonebook.Actions

import phonebook.Model.Fio
import phonebook.Model.Phone
import java.util.*

open class Operations {
    companion object {
        //Collections
        internal var phoneList: List<Phone> = ArrayList()
        internal var phonebook: MutableMap<Fio, List<Phone>> = HashMap()

        //add contact if fio and number is correct
        fun addContact() {
            //enter fio
            val fio = Mask.checkFio()
            //enter phone
            val phone = Mask.checkPhone()

            //put fio and phone into collection if data isn't null
            var phoneList: MutableList<Phone>? = phonebook[fio] as MutableList<Phone>?
            if (phoneList == null) {
                phoneList = ArrayList()
                phonebook[fio] = phoneList
            }
            phoneList.add(phone)

            println("Operation successfull\n")
        }

        //view all contacts
        fun viewAll() {
            if (phonebook.isNotEmpty()) {
                for ((fio, phoneList) in phonebook) {
                    fio.printFio()
                    for (phone in phoneList) {
                        phone.printPhone()
                    }
                }
            } else {
                println("No data in phonebook")
            }
        }

        //deleteContact contact by fio
        fun deleteContact() {
            if (phonebook.isNotEmpty()) {
                val fio = Mask.checkFio()
                val phoneList = phonebook[fio]
                if (phoneList != null) {
                    phonebook.remove(fio)
                    println("Operation successfull\n")
                } else {
                    println("Fio hasn't been found")
                }
            } else {
                println("No data in phonebook")
            }
        }


        //search contact by fio
        fun findByFio() {
            if (phonebook.isNotEmpty()) {
                val fio = Mask.checkFio()
                val phoneList = phonebook[fio]
                if (phoneList != null) {
                    fio.printFio()
                    for (phone in phoneList) {
                        phone.printPhone()
                    }
                } else {
                    println("Fio hasn't been found")
                }
            } else {
                println("No data in phonebook")
            }
        }

        //search contact by phone
        fun findByPhone() {
            if (phonebook.isNotEmpty()) {
                val phone = Mask.checkPhone()
                for ((fio, value) in phonebook) {
                    if (value.contains(phone)) {
                        phone.printPhone()
                        fio.printFio()
                    } else {
                        println("Phone number hasn't been found")
                    }
                }
            } else {
                println("No data in phonebook")
            }
        }
    }
}
