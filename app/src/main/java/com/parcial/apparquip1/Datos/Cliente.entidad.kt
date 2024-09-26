package com.parcial.apparquip1.Datos

class Cliente {
    var id: Int = 0
    var nombre: String = ""
    var meta: String = ""
    var telefono: String = ""
    var caracteristicas: String = ""

    constructor(
        id: Int, nombre: String, meta: String, telefono: String, caracteristicas: String
    ) {
        this.id = id
        this.nombre = nombre
        this.meta = meta
        this.telefono = telefono
        this.caracteristicas = caracteristicas
    }

    public fun obtenerId(): Int {
        return this.id
    }

    public fun establecerId(id: Int) {
        this.id = id
    }

    public fun obtenerNombre(): String {
        return this.nombre
    }

    public fun obtenerMeta(): String {
        return this.meta
    }

    public fun obtenerTelefono(): String {
        return this.telefono
    }

    public fun obtenerCaracteristicas(): String {
        return this.caracteristicas
    }

    public fun establecerNombre(nombre: String) {
        this.nombre = nombre
    }

    public fun establecerMeta(meta: String) {
        this.meta = meta
    }

    public fun establecerTelefono(telefono: String) {
        this.telefono = telefono
    }

    public fun establecerCaracteristicas(caracteristicas: String) {
        this.caracteristicas = caracteristicas
    }


}