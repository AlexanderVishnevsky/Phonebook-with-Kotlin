package phonebook

import java.io.IOException

object RunPhonebook {

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        Phonebook.runMenu()
    }
}