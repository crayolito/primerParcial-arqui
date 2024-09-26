package com.parcial.apparquip1.Negocio

import android.content.Context
import com.parcial.apparquip1.Datos.Alimentacion
import com.parcial.apparquip1.Datos.DRutina
import com.parcial.apparquip1.Datos.PlanEjercicio
import com.parcial.apparquip1.Datos.Rutina

class NRutina(context: Context) {
    private val dRutina: DRutina = DRutina(context)

    fun obtenerRutina(id: Int): Rutina? {
        if (id <= 0) {
            return null
        }

        return dRutina.obtenerRutina(id)
    }

    fun insertarRutina(
        idPlanAlimentacion: Int, idPlanesEjercicios: List<PlanEjercicio>, rutina: Rutina
    ): String {
        return dRutina.insertarRutina(idPlanAlimentacion, idPlanesEjercicios, rutina)
    }

    fun obtenerRutinas(): List<Rutina> {
        return dRutina.obtenerRutinas()
    }

    fun actualizarRutina(idPlanAlimentacion: Int, idPlanesEjercicios: List<PlanEjercicio>, rutina: Rutina): String {
        if (idPlanAlimentacion <= 0) {
            return "El id del plan de alimentación no es válido"
        }

        return dRutina.actualizarRutina(idPlanAlimentacion, idPlanesEjercicios, rutina)
    }

    fun eliminarRutina(id: Int): String {
        if (id <= 0) {
            return "El id de la rutina no es válido"
        }

        return dRutina.eliminarRutina(id)
    }
}