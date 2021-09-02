package com.example.wsclientteste1

import org.ksoap2.serialization.KvmSerializable
import org.ksoap2.serialization.PropertyInfo
import java.util.*

data class Curso (val nome: String, val codigo: Int) : KvmSerializable {

    override fun getPropertyInfo(index: Int, properties: Hashtable<*, *>?, info: PropertyInfo) {

        when (index) {
            0 -> {
                info.type = PropertyInfo.STRING_CLASS
                info.name = "nome"
            }
            1 -> {
                info.type = PropertyInfo.INTEGER_CLASS
                info.name = "codigo"
            }
            else -> {}
        }

    }

    override fun setProperty(index: Int, value: Any?) {

        when (index) {
            0 -> value.toString()
            1 -> codigo.toString()
            else -> "null"
        }

    }

    override fun getProperty(index: Int): Any {

        if(index == 0)
            return nome
        else if(index == 1)
            return codigo.toString()
        return "null"

    }

    override fun getPropertyCount(): Int {
        return 2
    }
}