package com.parcial.apparquip1.Datos

import android.content.ContentValues
import android.content.Context

class DAlimentos(context: Context) {
    private val dConexion: DConexion = DConexion(context)

    fun insertarAlimento(alimento: Alimentacion): String {
        println("HOLA ${alimento.titulo}")
        val db = dConexion.writableDatabase
        val contentValues = ContentValues().apply {
            put("titulo", alimento.titulo)
            put("descripcion", alimento.descripcion)
            put("noprocesado", alimento.noprocesado)
            put("procesado", alimento.procesado)
        }

        return try {
            val resultado = db.insert("alimentacion", null, contentValues)
            db.close()

            if (resultado != -1L) {
                println("HOLA $resultado")
                return "Se insertó correctamente"

            } else {
                "Ocurrió un error"
            }
        } catch (e: Exception) {
            e.printStackTrace()
            "Ocurrió un error"
        }
    }

    fun obtenerAlimentos(): ArrayList<Alimentacion> {
        val alimentos = ArrayList<Alimentacion>()
        try {
            val db = dConexion.readableDatabase
            val cursor = db.rawQuery("SELECT * FROM alimentacion", null)

            val idIndex = cursor.getColumnIndex("id")
            val tituloIndex = cursor.getColumnIndex("titulo")
            val descripcionIndex = cursor.getColumnIndex("descripcion")
            val noprocesadoIndex = cursor.getColumnIndex("noprocesado")
            val procesadoIndex = cursor.getColumnIndex("procesado")

            if (idIndex != -1 && tituloIndex != -1 && descripcionIndex != -1 && noprocesadoIndex != -1 && procesadoIndex != -1) {
                while (cursor.moveToNext()) {
                    val id = cursor.getInt(idIndex)
                    val titulo = cursor.getString(tituloIndex)
                    val descripcion = cursor.getString(descripcionIndex)
                    val noprocesado = cursor.getString(noprocesadoIndex)
                    val procesado = cursor.getString(procesadoIndex)
                    alimentos.add(Alimentacion(id, titulo, descripcion, noprocesado, procesado))
                }
            }

            cursor.close()
            db.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return alimentos
    }

    fun actualizarAlimento(alimento: Alimentacion): String {
        val db = dConexion.writableDatabase
        val contentValues = ContentValues().apply {
            put("titulo", alimento.titulo)
            put("descripcion", alimento.descripcion)
            put("noprocesado", alimento.noprocesado)
            put("procesado", alimento.procesado)
        }

        return try {
            val resultado =
                db.update("alimentacion", contentValues, "id = ?", arrayOf(alimento.id.toString()))
            db.close()

            if (resultado != -1) {
                "Se actualizó correctamente"
            } else {
                "Ocurrió un error"
            }
        } catch (e: Exception) {
            e.printStackTrace()
            "Ocurrió un error"
        }
    }

    fun eliminarAlimento(id: Int): String {
        val db = dConexion.writableDatabase
        return try {
            val resultado = db.delete("alimentacion", "id = ?", arrayOf(id.toString()))
            db.close()

            if (resultado != -1) {
                "Se eliminó correctamente"
            } else {
                "Ocurrió un error"
            }
        } catch (e: Exception) {
            e.printStackTrace()
            "Ocurrió un error"
        }
    }

    fun getRelacionOfRutina(id: Int): List<Rutina> {
        val rutinas = ArrayList<Rutina>()
        try {
            val db = dConexion.readableDatabase
            val cursor = db.rawQuery(
                "SELECT * FROM rutina WHERE id_planAlimentacion = ?", arrayOf(id.toString())
            )

            val idIndex = cursor.getColumnIndex("id")
            val tituloIndex = cursor.getColumnIndex("titulo")
            val idPlanAlimentacionIndex = cursor.getColumnIndex("id_planAlimentacion")

            if (idIndex != -1 && tituloIndex != -1 && idPlanAlimentacionIndex != -1) {
                while (cursor.moveToNext()) {
                    val id = cursor.getInt(idIndex)
                    val titulo = cursor.getString(tituloIndex)
                    val idPlanAlimentacion = cursor.getInt(idPlanAlimentacionIndex)
                    rutinas.add(Rutina(id, titulo, idPlanAlimentacion))
                }
            }

            cursor.close()
            db.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return rutinas
    }
}
