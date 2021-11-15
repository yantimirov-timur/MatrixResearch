class WorkerThread(
    val row: Int,
    val col: Int,
    val A: Array<IntArray>,
    val B: Array<IntArray>,
    val C: Array<IntArray>,

    ) : Thread() {

    override fun run() {
        C[row][col] = (A[row][0] * B[0][col]) + (A[row][1] * B[1][col])
    }

}