package com.parcial.apparquip1.Negocio

import android.content.Context
import com.parcial.apparquip1.Datos.entidades.Alimentacion
import com.parcial.apparquip1.Datos.DAlimentos
import com.parcial.apparquip1.Datos.entidades.Rutina

class NAlimentacion(context: Context) {
    private val dAlimentos: DAlimentos = DAlimentos(context)

    fun insertarPlanAlimentacion(
        titulo: String, descripcion: String, noprocesado: String, procesado: String
    ): String {
        if (titulo.isEmpty() || descripcion.isEmpty() || noprocesado.isEmpty() || procesado.isEmpty()) {
            return "Faltan datos"
        }
        dAlimentos.titulo = titulo
        dAlimentos.descripcion = descripcion
        dAlimentos.noprocesado = noprocesado
        dAlimentos.procesado = procesado
        return dAlimentos.insertarAlimento()
    }

    fun getPlanesAlimentacion(): List<Alimentacion> {
        return dAlimentos.obtenerAlimentos()
    }

    fun updatePlanAlimentacion(
        id: Int, titulo: String, descripcion: String, noprocesado: String, procesado: String
    ): String {
        if (titulo.isEmpty() || descripcion.isEmpty() || noprocesado.isEmpty() || procesado.isEmpty()) {
            return "Alimento no encontrado"
        }
        dAlimentos.id = id
        dAlimentos.titulo = titulo
        dAlimentos.descripcion = descripcion
        dAlimentos.noprocesado = noprocesado
        dAlimentos.procesado = procesado
        return dAlimentos.actualizarAlimento()
    }

    fun deletePlanAlimentacion(id: Int): String {
        if (id == null) {
            return "Alimento no encontrado"
        }
        dAlimentos.id = id
        return dAlimentos.eliminarAlimento()
    }

    fun getRelacionOfRutina(id: Int): List<Rutina> {
        if (id == null) {
            return emptyList()
        }
        dAlimentos.id = id
        return dAlimentos.getRelacionOfRutina()
    }
}