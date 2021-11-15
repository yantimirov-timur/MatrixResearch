class RowMultiplierWorker(
    val result: Array<Array<Int>>,
    val matrixA: Array<Array<Int>>,
    val matrixB: Array<Array<Int>>,
    val row: Int
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