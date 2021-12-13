package multiplication

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


internal class MatrixMultiplierTest {
    private val matrix1 = Array(3) { Array(3) { 1 } }
    private val matrix2 = Array(3) { Array(3) { 3 } }

    private fun fillMatrix(num: Int, size: Int, matrix: Array<Array<Int>>) {
        for (i in 0 until size) {
            for (j in 0 until size) {
                matrix[i][j] = num
            }
        }
    }

    @Test
    fun multiply() {
        val expectedResult = Array(3) { Array(3) { 0 } }
        val fillNum = 1
        fillMatrix(fillNum, expectedResult.size, expectedResult)
        val res = MatrixMultiplier().multiply(matrix1, matrix2)
        assertArrayEquals(expectedResult, res)
    }
}