package com.example.myapplication

fun main() {
    val ecuacionSegundoGrado = { a: Double, b: Double, c: Double ->
        when {
            a == 0.0 -> {
                if (b != 0.0) {
                    arrayOf(2.0, -c / b, 0.0)
                } else {
                    arrayOf(0.0, 0.0, 0.0)
                }
            }
            else -> {
                val numero = b * b - 4 * a * c
                when {
                    numero > 0 -> {
                        val x1 = (-b + kotlin.math.sqrt(numero)) / (2 * a)
                        val x2 = (-b - kotlin.math.sqrt(numero)) / (2 * a)
                        arrayOf(1.0, x1, x2)
                    }
                    numero == 0.0 -> {
                        val x1 = -b / (2 * a)
                        arrayOf(1.0, x1, x1)
                    }
                    else -> arrayOf(0.0, 0.0, 0.0)
                }
            }
        }
    }

    val funcionUno = { a: Double, b: Double, c: Double, solver: (Double, Double, Double) -> Array<Double> ->
        val resultados = solver(a, b, c)
        when (resultados[0]) {
            0.0 -> 0.0
            1.0 -> kotlin.math.abs(resultados[1]) + kotlin.math.abs(resultados[2])
            2.0 -> resultados[1]
            else -> 0.0
        }
    }

    //paso2
    val multiplicacion = { x: Double, y: Double, z: Double ->
        if (x == 0.0 && y == 0.0 && z == 0.0) 1.0
        else x * y * z
    }

    //paso3
    val funcionDos = { a: Double, b: Double, c: Double, sumLambda: (Array<Double>) -> Double ->
        val array = arrayOf(a, b, c)
        sumLambda(array)
    }

    val sumatorioLambda = { array: Array<Double> ->
        array.sum()
    }

    val resultado1 = funcionUno(1.0, -3.0, 2.0, ecuacionSegundoGrado)
    println("Resultado para (1, -3, 2): $resultado1")

    val resultado2 = funcionUno(1.0, -2.0, 1.0, ecuacionSegundoGrado)
    println("Resultado para (1, -2, 1): $resultado2")

    val resultado3 = funcionUno(0.0, 4.0, -8.0, ecuacionSegundoGrado)
    println("Resultado para (0, 4, -8): $resultado3")

    val resultado4 = funcionUno(1.0, 2.0, 3.0, ecuacionSegundoGrado)
    println("Resultado para (1, 2, 3): $resultado4")

    val resultadoMultiplicacion = multiplicacion(2.0, 3.0, 4.0)
    println("Resultado de la multiplicación para (2, 3, 4): $resultadoMultiplicacion")

    val resultadoMultiplicacionCero = multiplicacion(0.0, 0.0, 0.0)
    println("Resultado de la multiplicación para (0, 0, 0): $resultadoMultiplicacionCero")

    val resultadoSumatorio = funcionDos(1.0, 2.0, 3.0, sumatorioLambda)
    println("Resultado del sumatorio para (1, 2, 3): $resultadoSumatorio")
}