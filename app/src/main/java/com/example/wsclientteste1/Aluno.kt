package com.example.wsclientteste1

import org.ksoap2.serialization.KvmSerializable
import org.ksoap2.serialization.PropertyInfo
import java.util.*

data class Aluno (
    val ra: String,
    val nome: String,
    val id: Int? = 0) : KvmSerializable {

    override fun getPropertyInfo(index: Int, properties: Hashtable<*, *>?, info: PropertyInfo) {
        when(index) {
            0 -> {
                info.type = PropertyInfo.STRING_CLASS
                info.name = "ra"
            }
            1 -> {
                info.type = PropertyInfo.STRING_CLASS
                info.name = "nome"
            }
            2 -> {
                info.type = PropertyInfo.INTEGER_CLASS
                info.name = "id"
            }
            else -> "null"

        }
    }

    override fun setProperty(index: Int, value: Any?) {
        when(index) {
            0 -> value.toString()
            1 -> value.toString()
            2 -> Integer.parseInt(value.toString())
            else -> "null"
        }
    }

    override fun getProperty(index: Int): Any =
        when(index) {
            0 -> ra
            1 -> nome
            2 -> id.toString()
            else -> "null"
        }

    override fun getPropertyCount(): Int {
        return 3
    }
}