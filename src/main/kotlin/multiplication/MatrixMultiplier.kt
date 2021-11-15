package multiplication


import matrix.MatrixBuilder

class MatrixMultiplier {
    fun multiply(matrixA: Array<Array<Int>>, matrixB: Array<Array<Int>>): Array<Array<Int>> {
        val sizeA = matrixA.size
        val sizeB = matrixB.size
        val result = MatrixBuilder(matrixA.size, sizeB).buildMatrix(0)

        for (i in 0 until sizeA) {
            for (j in 0 until sizeB) {
                for (k in 0 until sizeB) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j]
                }
            }
        }
        return result
    }
}