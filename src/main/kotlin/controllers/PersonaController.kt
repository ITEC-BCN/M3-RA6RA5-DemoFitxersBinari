package itb.controllers

import itb.models.Persona
import java.io.*

fun afegirPersona(fitxer: String, persona: Persona) {
    val persones = llegirPersones(fitxer).toMutableList()
    persones.add(persona)

    ObjectOutputStream(FileOutputStream(fitxer)).use { oos ->
        oos.writeObject(persones)
    }
    println("Persona afegida correctament.")
}

fun llegirPersones(fitxer: String): List<Persona> {
    val file = File(fitxer)
    if (!file.exists() || file.length() == 0L) return emptyList()

    ObjectInputStream(FileInputStream(fitxer)).use { ois ->
        return ois.readObject() as List<Persona>
    }
}