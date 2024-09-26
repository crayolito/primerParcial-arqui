package com.parcial.apparquip1.Negocio

import android.content.Context
import com.parcial.apparquip1.Datos.Alimentacion
import com.parcial.apparquip1.Datos.DAlimentos
import com.parcial.apparquip1.Datos.Rutina

class NAlimentacion(context: Context) {
    private val dAlimentos: DAlimentos = DAlimentos(context)

    fun insertarPlanAlimentacion(
        titulo: String, descripcion: String, noprocesado: String, procesado: String
    ): String {
        if (titulo.isEmpty() || descripcion.isEmpty() || noprocesado.isEmpty() || procesado.isEmpty()) {
            return "Faltan datos"
        }
        val alimento: Alimentacion = Alimentacion(0, titulo, descripcion, noprocesado, procesado)
        return dAlimentos.insertarAlimento(alimento)
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
        val alimento: Alimentacion = Alimentacion(id, titulo, descripcion, noprocesado, procesado)
        return dAlimentos.actualizarAlimento(alimento)
    }

    fun deletePlanAlimentacion(id: Int): String {
        if (id == null) {
            return "Alimento no encontrado"
        }
        return dAlimentos.eliminarAlimento(id)
    }

    fun getRelacionOfRutina(id: Int): List<Rutina> {
        return dAlimentos.getRelacionOfRutina(id)
    }
}