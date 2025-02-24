package itb

import itb.models.GestorPersones
import itb.models.Persona

fun main() {

    val gestor = GestorPersones("./txt/persones.dat")

    var sortir: Boolean = false

    do {
        println("\n1. Afegir persona")
        println("2. Llistar persones")
        println("0. SORTIR")
        print("Escull una opció: ")

        when (readln()) {
            "1" -> {
                print("Introdueix el nom: ")
                val nom = readln()
                print("Introdueix el mail: ")
                val mail = readln()
                gestor.afegirPersona(Persona(nom, mail))
            }
            "2" -> {
                val persones = gestor.llegirPersones()
                if (persones.isEmpty()) println("No hi ha persones guardades.")
                else persones.forEach {
                    println(it)
                }
            }
            "0" -> {
                sortir = true
            }
            else -> println("ERROR: Opció incorrecta!")
        }
    } while (!sortir)

}