package com.parcial.apparquip1.Presentacion

import com.parcial.apparquip1.Datos.Alimentacion
import com.parcial.apparquip1.Datos.PlanEjercicio
import com.parcial.apparquip1.Datos.Rutina
import com.parcial.apparquip1.Negocio.NAlimentacion
import com.parcial.apparquip1.Negocio.NPlanEjercicio
import com.parcial.apparquip1.Negocio.NRutina
import android.content.Context

class PRutina(context: Context) {
    private val nRutina: NRutina = NRutina(context)
    private val nPlanEjercicio: NPlanEjercicio = NPlanEjercicio(context)
    private val nAlimentacion: NAlimentacion = NAlimentacion(context)

    fun obtenerRutina(id: Int): Rutina? {
        return nRutina.obtenerRutina(id)
    }

    fun insertarRutina(
        idPlanAlimentacion: Int,
        idPlanesEjercicios: List<PlanEjercicio>,
        rutina: Rutina
    ): String {
        return nRutina.insertarRutina(idPlanAlimentacion, idPlanesEjercicios, rutina)
    }

    fun obtenerRutinas(): List<Rutina> {
        return nRutina.obtenerRutinas()
    }

    fun actualizarRutina(
        idPlanAlimentacion: Int,
        idPlanesEjercicios: List<PlanEjercicio>,
        rutina: Rutina
    ): String {
        return nRutina.actualizarRutina(idPlanAlimentacion, idPlanesEjercicios, rutina)
    }

    fun eliminarRutina(id: Int): String {
        return nRutina.eliminarRutina(id)
    }

    fun getPlanesEjercicios(): List<PlanEjercicio> {
        return nPlanEjercicio.obtenerPlanesEjercicio()
    }

    fun getPlanesAlimentacion(): List<Alimentacion> {
        return nAlimentacion.getPlanesAlimentacion()
    }
}