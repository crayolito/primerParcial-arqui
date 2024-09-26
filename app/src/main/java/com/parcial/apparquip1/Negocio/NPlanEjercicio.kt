package com.parcial.apparquip1.Negocio

import android.content.Context
import com.parcial.apparquip1.Datos.DPlanEjercicio
import com.parcial.apparquip1.Datos.PlanEjercicio
import com.parcial.apparquip1.Datos.Rutina

class NPlanEjercicio(context: Context) {
    private val dPlanEjercicio: DPlanEjercicio = DPlanEjercicio(context)

    fun insertarPlanEjercicio(
        idCategoriaEjercicio: Int,
        titulo: String,
        motivo: String,
        objetivo: String,
        video: String,
        proceso: String
    ): String {
        if (titulo.isEmpty() || motivo.isEmpty() || objetivo.isEmpty() || video.isEmpty() || proceso.isEmpty()) {
            return "Faltan datos"
        }
        val planEjercicio: PlanEjercicio =
            PlanEjercicio(0, titulo, motivo, objetivo, video, proceso)
        return dPlanEjercicio.insertarPlanEjercicio(idCategoriaEjercicio, planEjercicio)
    }

    fun obtenerPlanesEjercicio(): List<PlanEjercicio> {
        return dPlanEjercicio.obtenerPlanesEjercicio()
    }

    fun actualizarPlanEjercicio(
        idCategoriaEjercicio: Int,
        id: Int,
        titulo: String,
        motivo: String,
        objetivo: String,
        video: String,
        proceso: String
    ): String {
        if (titulo.isEmpty() || motivo.isEmpty() || objetivo.isEmpty() || video.isEmpty() || proceso.isEmpty()) {
            return "Faltan datos"
        }
        val planEjercicio: PlanEjercicio =
            PlanEjercicio(id, titulo, motivo, objetivo, video, proceso)
        return dPlanEjercicio.actualizarPlanEjercicio(idCategoriaEjercicio,planEjercicio)
    }

    fun eliminarPlanEjercicio(id: Int): String {
        if (id == null) {
            return "Plan de ejercicio no encontrado"
        }
        return dPlanEjercicio.eliminarPlanEjercicio(id)
    }

    fun getRelacionOfRutina(id: Int): List<Rutina> {
        return dPlanEjercicio.getRelacionOfRutina(id)
    }
}