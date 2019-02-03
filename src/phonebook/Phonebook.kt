package phonebook

import phonebook.Actions.ConsoleReader
import phonebook.Actions.Operations
import java.io.IOException

class Phonebook : Operations() {
    companion object {

        @Throws(IOException::class)
        fun runMenu() {
            var st: String
            do {
                println("\n" +
                        "Welcome to phonebook\n" +
                        "---------------------\n" +
                        " \n" + "If you'd like to see list of commands please enter: info\n" +
                        " \n" + "If you'd like to exit please enter: exit\n" + "\n")
                st = ConsoleReader.readFromConsole()

                when (st.toLowerCase()) {
                    "info" -> select()
                    "exit" -> return
                    else -> println("Please, enter right command")
                }
            } while (st != "info,exit")
        }

        @Throws(IOException::class)
        fun select() {
            //phonebook.Phonebook with commands add, view, deleteContact, quit
            var menu: String

            do {
                println("\n" +
                        "Options:\n" +
                        "add - Adding user\n" +
                        "view - View all users\n" +
                        "del - Delete user\n" +
                        "find - Search user\n" +
                        "exit - Quit from app\n")
                menu = ConsoleReader.readFromConsole()

                when (menu.toLowerCase()) {
                    "add" -> do {
                        Operations.Companion.addContact()
                    } while (menu == "")
                    "view" -> do {
                        Operations.Companion.viewAll()
                    } while (menu == "")
                    "del" -> do {
                        Operations.Companion.deleteContact()
                    } while (menu == "")
                    "find" -> do {
                        println("\n" +
                                "Would you like search by fio or by Phone?:\n" +
                                "u - search by user\n" +
                                "p - search by phone\n")
                        menu = ConsoleReader.readFromConsole()
                        if (menu.equals("u", ignoreCase = true)) {
                            Operations.Companion.findByFio()
                        } else if (menu.equals("p", ignoreCase = true)) {
                            Operations.Companion.findByPhone()
                        } else
                            println("Enter correct command, please")
                    } while (menu == "")
                    "exit" -> {
                        do {
                            return
                        } while (menu == "")
                        println("Enter correct command, please")
                    }
                    else -> println("Enter correct command, please")
                }
            } while (menu != "add,view,del,findByFio,quit")
        }
    }
}