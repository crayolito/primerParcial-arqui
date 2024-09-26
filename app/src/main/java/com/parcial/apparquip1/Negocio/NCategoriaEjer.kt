package com.parcial.apparquip1.Negocio

import android.content.Context
import com.parcial.apparquip1.Datos.CategoriaEjer
import com.parcial.apparquip1.Datos.DCategoriaEjer
import com.parcial.apparquip1.Datos.PlanEjercicio

class NCategoriaEjer(context: Context) {
    private val dCategoriaEjer: DCategoriaEjer = DCategoriaEjer(context)

    fun insertarCategoriaEjer(nombre: String, descripcion: String): String {
        if (nombre.isEmpty() || descripcion.isEmpty()) {
            return "Faltan datos"
        }
        val categoriaEjer: CategoriaEjer = CategoriaEjer(0, nombre, descripcion)
        return dCategoriaEjer.insertarCategoriaEjer(categoriaEjer)
    }

    fun obtenerCategoriasEjer(): List<CategoriaEjer> {
        return dCategoriaEjer.obtenerCategoriasEjer()
    }

    fun actualizarCategoriaEjer(id: Int, nombre: String, descripcion: String): String {
        if (nombre == null || descripcion == null) {
            return "Categoria no encontrada"
        }
        val categoriaEjer: CategoriaEjer = CategoriaEjer(id, nombre, descripcion)
        return dCategoriaEjer.actualizarCategoriaEjer(categoriaEjer)
    }

    fun eliminarCategoriaEjer(id: Int): String {
        if (id == null) {
            return "Categoria no encontrada"
        }
        return dCategoriaEjer.eliminarCategoriaEjer(id);
    }

    fun getRelacionOfCategoriaEjer(idCategoriaEjercicio: Int): List<PlanEjercicio> {
        return dCategoriaEjer.getRelacionOfCategoriaEjer(idCategoriaEjercicio)
    }

}