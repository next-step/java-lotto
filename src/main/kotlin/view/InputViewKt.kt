package view

import java.util.Scanner

object InputViewKt {

    private val scanner = Scanner(System.`in`)

    fun getInputNumber(message: String): Int {
        println(message)
        return scanner.nextInt()
    }

    fun getInputString(message: String): String {
        println(message)
        return scanner.next()
    }
}
