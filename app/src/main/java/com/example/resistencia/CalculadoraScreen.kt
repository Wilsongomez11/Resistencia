package com.example.resistencia

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api

@ExperimentalMaterial3Api
@Composable
fun CalculadoraScreen() {
    var banda1 by remember { mutableStateOf("Marrón") }
    var banda2 by remember { mutableStateOf("Negro") }
    var multiplicador by remember { mutableStateOf("Negro") }
    var tolerancia by remember { mutableStateOf("Dorado") }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Calculadora de Resistencia", style = MaterialTheme.typography.headlineSmall)

        ColorDropdown("Banda 1", coloresValor, banda1) { banda1 = it }
        ColorDropdown("Banda 2", coloresValor, banda2) { banda2 = it }
        ColorDropdown("Multiplicador", coloresMultiplicador, multiplicador) { multiplicador = it }
        ColorDropdown("Tolerancia", coloresTolerancia, tolerancia) { tolerancia = it }

        Button(onClick = {
            resultado = calcularResistencia(banda1, banda2, multiplicador, tolerancia)
        }) {
            Text("Calcular")
        }

        if (resultado.isNotEmpty()) {
            Text(text = resultado, style = MaterialTheme.typography.headlineMedium)
        }
    }
}
