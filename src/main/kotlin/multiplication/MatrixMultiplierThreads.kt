package multiplication

class MatrixMultiplierThreads(
    private val result: Array<Array<Int>>,
    private val matrixA: Array<Array<Int>>,
    private val matrixB: Array<Array<Int>>,
    private val row: Int
) : Runnable {
    override fun run() {
        for (i in 0 until matrixB[0].size) {
            result[row][i] = 0
            for (j in 0 until matrixA[row].size) {
                result[row][i] += matrixA[row][j] * matrixB[j][i]
            }
        }
    }
}