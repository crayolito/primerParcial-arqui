package com.parcial.apparquip1.Negocio

import android.content.Context
import com.parcial.apparquip1.Datos.entidades.Cliente
import com.parcial.apparquip1.Datos.DCliente

//class NCliente(context: Context) {
//    private val dCliente: DCliente
//
//    init {
//        dCliente = DCliente(context)
//    }
//}

class NCliente(context: Context) {
    private val dCliente: DCliente = DCliente(context)


    fun insertarCliente(
        nombre: String, telefono: String, meta: String, caracteristicas: String
    ): String {
        if (nombre.isEmpty() || telefono.isEmpty()) {
            return "Faltan datos"
        }
        dCliente.nombre = nombre
        dCliente.telefono = telefono
        dCliente.meta = meta
        dCliente.caracteristicas = caracteristicas
        return dCliente.insertarCliente()
    }

    fun obtenerClientes(): List<Cliente> {
        return dCliente.obtenerClientes()
    }

    fun actualizarCliente(
        id: Int, nombre: String, telefono: String, meta: String, caracteristicas: String
    ): String {
        if (dCliente.nombre == null || dCliente.telefono == null) {
            return "Cliente no encontrado"
        }
        dCliente.id = id
        dCliente.nombre = nombre
        dCliente.telefono = telefono
        dCliente.meta = meta
        dCliente.caracteristicas = caracteristicas
        return dCliente.actualizarCliente()
    }

    fun eliminarCliente(id: Int): String {
        if (id == null) {
            return "Cliente no encontrado"
        }
        dCliente.id = id
        return dCliente.eliminarCliente(id);
    }
}