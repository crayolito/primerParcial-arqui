package com.parcial.apparquip1.Presentacion

import android.content.Context
import com.parcial.apparquip1.Datos.Alimentacion
import com.parcial.apparquip1.Datos.CategoriaEjer
import com.parcial.apparquip1.Datos.PlanEjercicio
import com.parcial.apparquip1.Negocio.NCategoriaEjer
import com.parcial.apparquip1.Negocio.NPlanEjercicio

class PCategoriEjer(context: Context) {
    private val nCategoriEjer: NCategoriaEjer = NCategoriaEjer(context)

    fun insertarCategoriaEjer(nombre: String, descripcion: String): String {
        return nCategoriEjer.insertarCategoriaEjer(nombre, descripcion)
    }

    fun obtenerCategoriasEjer(): List<CategoriaEjer> {
        return nCategoriEjer.obtenerCategoriasEjer()
    }

    fun actualizarCategoriaEjer(id: Int, nombre: String, descripcion: String): String {
        return nCategoriEjer.actualizarCategoriaEjer(id, nombre, descripcion)
    }

    fun eliminarCategoriaEjer(id: Int): String {
        return nCategoriEjer.eliminarCategoriaEjer(id)
    }

    fun getRelacionOfCategoriaEjer(idCategoriaEjercicio: Int): List<PlanEjercicio> {
        return nCategoriEjer.getRelacionOfCategoriaEjer(idCategoriaEjercicio)
    }
}