package com.parcial.apparquip1.Datos

import android.content.ContentValues
import android.content.Context


class DCliente(context: Context) {
    private val dConexion: DConexion = DConexion(context)

    fun insertarCliente(cliente: Cliente): String {
        val db = dConexion.writableDatabase
        val contentValues = ContentValues().apply {
            put("nombre", cliente.nombre)
            put("telefono", cliente.telefono)
            put("meta", cliente.meta)
            put("caracteristicas", cliente.caracteristicas)
        }

        return try {
            val resultado = db.insert("cliente", null, contentValues)
            db.close()

            if (resultado != -1L) {
                "Se insertó correctamente"
            } else {
                "Ocurrió un error"
            }
        } catch (e: Exception) {
            e.printStackTrace()
            "Error al insertar: ${e.message}"
        }
    }

    fun obtenerClientes(): List<Cliente> {
        val clientes = mutableListOf<Cliente>()
        try {
            val db = dConexion.readableDatabase
            val cursor = db.rawQuery("SELECT * FROM cliente ORDER BY id DESC", null)

            val idIndex = cursor.getColumnIndex("id")
            val nombreIndex = cursor.getColumnIndex("nombre")
            val telefonoIndex = cursor.getColumnIndex("telefono")
            val metaIndex = cursor.getColumnIndex("meta")
            val caracteristicasIndex = cursor.getColumnIndex("caracteristicas")

            if (idIndex != -1 && nombreIndex != -1 && metaIndex != -1 && telefonoIndex != -1 && caracteristicasIndex != -1) {
                while (cursor.moveToNext()) {
                    val id = cursor.getInt(idIndex)
                    val nombre = cursor.getString(nombreIndex)
                    val meta = cursor.getString(metaIndex)
                    val telefono = cursor.getString(telefonoIndex)
                    val caracteristicas = cursor.getString(caracteristicasIndex)
                    val cliente = Cliente(id, nombre, meta, telefono, caracteristicas)
                    clientes.add(cliente)
                }
            }

            cursor.close()
            db.close()
        } catch (e: Exception) {
            // Aquí puedes manejar el error como desees. Por ejemplo, puedes imprimir el error:
            e.printStackTrace()
        }

        return clientes
    }

    fun actualizarCliente(cliente: Cliente): String {
        return try {
            val db = dConexion.writableDatabase
            val contentValues = ContentValues().apply {
                put("nombre", cliente.nombre)
                put("telefono", cliente.telefono)
                put("meta", cliente.meta)
                put("caracteristicas", cliente.caracteristicas)
            }
            val resultado = db.update(
                "cliente", contentValues, "id = ?", arrayOf(cliente.id.toString())
            )
            db.close()
            if (resultado > 0) {
                "Se actualizó correctamente"
            } else {
                "Ocurrió un error al actualizar"
            }
        } catch (e: Exception) {
            e.printStackTrace()
            "Error al actualizar: ${e.message}"
        }
    }

    fun eliminarCliente(id: Int): String {
        println(id)
        return try {
            val db = dConexion.writableDatabase
            val resultado = db.delete("cliente", "id = ?", arrayOf(id.toString()))
            db.close()

            if (resultado > 0) {
                "Se eliminó correctamente"
            } else {
                "Ocurrió un error al eliminar"
            }
        } catch (e: Exception) {
            e.printStackTrace()
            "Error al eliminar: ${e.message}"
        }
    }
}