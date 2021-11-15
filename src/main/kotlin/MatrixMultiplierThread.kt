import multiplication.MatrixMultiplier

class MatrixMultiplierThread(
    val matrixA: Array<Array<Int>>,
    val matrixB: Array<Array<Int>>,
) : Runnable {
    override fun run() {
        MatrixMultiplier().multiply(matrixA, matrixB)
    }
}