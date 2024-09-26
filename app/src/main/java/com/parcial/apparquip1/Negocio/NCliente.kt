package com.parcial.apparquip1.Negocio

import android.content.Context
import com.parcial.apparquip1.Datos.Cliente
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
        val cliente: Cliente = Cliente(0, nombre, meta, telefono, caracteristicas)
        return dCliente.insertarCliente(cliente)
    }

    fun obtenerClientes(): List<Cliente> {
        return dCliente.obtenerClientes()
    }

    fun actualizarCliente(
        id: Int, nombre: String, telefono: String, meta: String, caracteristicas: String
    ): String {
        if (nombre == null || telefono == null) {
            return "Cliente no encontrado"
        }
        val cliente: Cliente = Cliente(id,nombre, meta, telefono, caracteristicas)
        return dCliente.actualizarCliente(cliente)
    }

    fun eliminarCliente(id: Int): String {

        if (id == null) {
            return "Cliente no encontrado"
        }
        return dCliente.eliminarCliente(id);
    }
}