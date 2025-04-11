package com.example.resistencia

val coloresValor = listOf("Negro", "Marrón", "Rojo", "Naranja", "Amarillo", "Verde", "Azul", "Violeta", "Gris", "Blanco")
val coloresMultiplicador = listOf("Negro", "Marrón", "Rojo", "Naranja", "Amarillo")
val coloresTolerancia = listOf("Dorado", "Plateado", "Ninguno")

fun calcularResistencia(b1: String, b2: String, mult: String, tol: String): String {
    val valor1 = coloresValor.indexOf(b1)
    val valor2 = coloresValor.indexOf(b2)
    val multiplicadores = listOf(1, 10, 100, 1000, 10000)
    val multiplicador = multiplicadores[coloresMultiplicador.indexOf(mult)]

    val tolerancia = when (tol) {
        "Dorado" -> "± 5%"
        "Plateado" -> "± 10%"
        "Ninguno" -> "± 20%"
        else -> "Tolerancia desconocida"
    }

    val resultado = (valor1 * 10 + valor2) * multiplicador
    return "$resultado Ω $tolerancia"
}

