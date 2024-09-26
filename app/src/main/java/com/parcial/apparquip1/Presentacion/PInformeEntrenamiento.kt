package com.parcial.apparquip1.Presentacion

import android.content.Context
import com.parcial.apparquip1.Datos.Alimentacion
import com.parcial.apparquip1.Datos.Cliente
import com.parcial.apparquip1.Datos.PlanEjercicio
import com.parcial.apparquip1.Datos.Rutina
import com.parcial.apparquip1.Negocio.NCliente
import com.parcial.apparquip1.Negocio.NInformeEntrenamiento
import com.parcial.apparquip1.Negocio.NRutina


class PInformeEntrenamiento(context: Context) {
    private val nInformeEjercicio: NInformeEntrenamiento = NInformeEntrenamiento(context);
    private val nRutina: NRutina = NRutina(context)
    private val nCliente: NCliente = NCliente(context)

    fun getPlanAlimentacionPorRutina(idRutina: Int): Alimentacion? {
        return nInformeEjercicio.getPlanAlimentacionPorRutina(idRutina)
    }

    fun getPlanesEjerciciosPorRutina(idRutina: Int): List<PlanEjercicio> {
        return nInformeEjercicio.getPlanesEjerciciosPorRutina(idRutina)
    }

    fun obtenerRutinas(): List<Rutina>{
        return nRutina.obtenerRutinas()
    }

    fun obtenerClientes(): List<Cliente>{
        return nCliente.obtenerClientes()
    }

    fun generarPdf(
        context: Context, alimentacion: Alimentacion, ejercicios: List<PlanEjercicio>
    ): String {
        return nInformeEjercicio.generarPdf(context, alimentacion, ejercicios)
    }

    fun abrirPdf(context: Context, path: String) {
        nInformeEjercicio.abrirPdf(context, path)
    }

    fun compartirPdfWhatsapp(context: Context, filePath: String, numeroWhatsapp: String) {
        nInformeEjercicio.compartirPdfWhatsapp(context, filePath, numeroWhatsapp)
    }
}