package phonebook.Actions

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

object ConsoleReader {
    @Throws(IOException::class)
    fun readFromConsole(): String {

        //readFromConsole input data
        val W = BufferedReader(InputStreamReader(System.`in`))
        var inputData = W.readLine().trim { it <= ' ' }

        //deleteContact unnecessary spaces between words
        while (inputData.contains("  ")) {
            val normFio = inputData.replace("  ", " ")
            inputData = normFio
        }
        return inputData
    }
}
