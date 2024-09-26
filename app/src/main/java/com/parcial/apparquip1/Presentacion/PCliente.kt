package com.parcial.apparquip1.Presentacion

import android.content.Context
import com.parcial.apparquip1.Datos.Cliente
import com.parcial.apparquip1.Negocio.NCliente
import kotlinx.coroutines.runBlocking


class PCliente(context: Context) {
    private val nCliente: NCliente = NCliente(context)

    fun insertarCliente(
        nombre: String,
        telefono: String,
        meta: String,
        caracteristicas: String
    ): String {
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

    fun actualizarCliente(
        id : Int,
        nombre: String,
        telefono: String,
        meta: String,
        caracteristicas: String
    ): String {
        return nCliente.actualizarCliente(
            id,
            nombre,
            telefono,
            meta,
            caracteristicas
        );
    }

    fun eliminarCliente(id: Int): String {
        return   nCliente.eliminarCliente(id)
    }
}