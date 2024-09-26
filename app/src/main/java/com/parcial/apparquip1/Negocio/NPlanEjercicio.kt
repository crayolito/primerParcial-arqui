package com.parcial.apparquip1.Negocio

import android.content.Context
import com.parcial.apparquip1.Datos.DPlanEjercicio
import com.parcial.apparquip1.Datos.entidades.PlanEjercicio
import com.parcial.apparquip1.Datos.entidades.Rutina

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
        dPlanEjercicio.idCategoriaEjercicio = idCategoriaEjercicio
        dPlanEjercicio.titulo = titulo
        dPlanEjercicio.motivo = motivo
        dPlanEjercicio.objetivo = objetivo
        dPlanEjercicio.video = video
        dPlanEjercicio.proceso = proceso
        return dPlanEjercicio.insertarPlanEjercicio()
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
        dPlanEjercicio.idCategoriaEjercicio = idCategoriaEjercicio
        dPlanEjercicio.id = id
        dPlanEjercicio.titulo = titulo
        dPlanEjercicio.motivo = motivo
        dPlanEjercicio.objetivo = objetivo
        dPlanEjercicio.video = video
        dPlanEjercicio.proceso = proceso
        return dPlanEjercicio.actualizarPlanEjercicio()
    }

    fun eliminarPlanEjercicio(id: Int): String {
        if (id == null) {
            return "Plan de ejercicio no encontrado"
        }
        dPlanEjercicio.id = id
        return dPlanEjercicio.eliminarPlanEjercicio()
    }

    fun getRelacionOfRutina(id: Int): List<Rutina> {
        dPlanEjercicio.id = id
        return dPlanEjercicio.getRelacionOfRutina()
    }
}