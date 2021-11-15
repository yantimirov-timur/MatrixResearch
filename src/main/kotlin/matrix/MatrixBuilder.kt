package matrix

import kotlin.random.Random

class MatrixBuilder(override val height: Int, override val width: Int) : Matrix {
    fun buildMatrix(matrixNumRange: Int): Array<Array<Int>> {
        val matrix = Array(height) { Array(width) { 0 } }
        for (i in 0 until width) {
            for (j in 0 until height) {
                if (matrixNumRange == 0) {
                    matrix[i][j] = 0
                } else {
                    matrix[i][j] = Random.nextInt(matrixNumRange)
                }
            }
        }
        return matrix
    }
}