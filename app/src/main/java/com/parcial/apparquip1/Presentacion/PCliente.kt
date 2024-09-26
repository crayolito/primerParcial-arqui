package com.parcial.apparquip1.Presentacion

import android.content.Context
import com.parcial.apparquip1.Datos.entidades.Cliente
import com.parcial.apparquip1.Negocio.NCliente


class PCliente(context: Context) {
    private val nCliente: NCliente = NCliente(context)

    var id: Int = 0
    var nombre: String = ""
    var telefono: String = ""
    var meta: String = ""
    var caracteristicas: String = ""

    fun insertarCliente(): String {
        return nCliente.insertarCliente(
            nombre,
            telefono,
            meta,
            caracteristicas
        );
    }

    fun obtenerClientes(): List<Cliente> {
        return nCliente.obtenerClientes()
    }

    fun actualizarCliente(): String {
        return nCliente.actualizarCliente(
            id,
            nombre,
            telefono,
            meta,
            caracteristicas
        );
    }

    fun eliminarCliente(): String {
        return   nCliente.eliminarCliente(id)
    }
}