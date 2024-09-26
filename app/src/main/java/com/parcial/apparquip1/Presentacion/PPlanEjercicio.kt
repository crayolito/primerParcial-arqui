package com.parcial.apparquip1.Presentacion

import android.content.Context
import com.parcial.apparquip1.Datos.CategoriaEjer
import com.parcial.apparquip1.Datos.PlanEjercicio
import com.parcial.apparquip1.Datos.Rutina
import com.parcial.apparquip1.Negocio.NCategoriaEjer
import com.parcial.apparquip1.Negocio.NPlanEjercicio

class PPlanEjercicio(context: Context) {
    private val nPlanEjercicio: NPlanEjercicio = NPlanEjercicio(context)
    private val nCategoriaEjer: NCategoriaEjer = NCategoriaEjer(context)

    fun insertarPlanEjercicio(
        idCategoriaEjercicio: Int,
        titulo: String,
        motivo: String,
        objetivo: String,
        video: String,
        proceso: String
    ): String {
        return nPlanEjercicio.insertarPlanEjercicio(
            idCategoriaEjercicio, titulo, motivo, objetivo, video, proceso
        );
    }

    fun obtenerPlanesEjercicio(): List<PlanEjercicio> {
        return nPlanEjercicio.obtenerPlanesEjercicio()
    }

    fun actualizarPlanEjercicio(
        idCategoriaEjercicio: Int,
        id: Int, titulo: String, motivo: String, objetivo: String, video: String, proceso: String
    ): String {
        return nPlanEjercicio.actualizarPlanEjercicio(
            idCategoriaEjercicio,id, titulo, motivo, objetivo, video, proceso
        );
    }

    fun eliminarPlanEjercicio(id: Int): String {
        return nPlanEjercicio.eliminarPlanEjercicio(id)
    }

    fun obtenerCategoriasEjer(): List<CategoriaEjer> {
        return nCategoriaEjer.obtenerCategoriasEjer();
    }

    fun getRelacionOfRutina(id: Int): List<Rutina> {
        return nPlanEjercicio.getRelacionOfRutina(id)
    }
}