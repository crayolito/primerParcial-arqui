package com.parcial.apparquip1.Presentacion

import android.content.Context
import com.parcial.apparquip1.Datos.Alimentacion
import com.parcial.apparquip1.Datos.Rutina
import com.parcial.apparquip1.Negocio.NAlimentacion

class PAlimentacion(context: Context) {
    private val nAlimentacion: NAlimentacion = NAlimentacion(context)

    fun insertarAlimento(
        titulo: String, descripcion: String, noprocesado: String, procesado: String
    ): String {
        return nAlimentacion.insertarPlanAlimentacion(titulo, descripcion, noprocesado, procesado)
    }

    fun obtenerAlimentos(): List<Alimentacion> {
        return nAlimentacion.getPlanesAlimentacion()
    }

    fun actualizarAlimento(
        id: Int, titulo: String, descripcion: String, noprocesado: String, procesado: String
    ): String {
        return nAlimentacion.updatePlanAlimentacion(id, titulo, descripcion, noprocesado, procesado)
    }

    fun eliminarAlimento(id: Int): String {
        return nAlimentacion.deletePlanAlimentacion(id)
    }

    fun getRelacionOfRutina(id: Int): List<Rutina> {
        return nAlimentacion.getRelacionOfRutina(id)
    }
}