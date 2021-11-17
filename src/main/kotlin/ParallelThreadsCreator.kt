import multiplication.MatrixMultiplierParallel
import kotlin.concurrent.thread

object ParallelThreadsCreator {
    fun multiply(
        matrixA: Array<Array<Int>>,
        matrixB: Array<Array<Int>>,
        result: Array<Array<Int>>,
        numThreads: Int
    ): Array<Array<Int>> {
        val threads = mutableListOf<Thread>()
        val rows1 = matrixA.size
        for (i in 0 until rows1) {
            val task = MatrixMultiplierParallel(result, matrixA, matrixB, i)
            val thread = Thread(task)
            thread.start()
            threads.add(thread)
            if (threads.size % numThreads == 0) {
                waitForThreads(threads)
            }
        }
        return result
    }

    private fun waitForThreads(threads: MutableList<Thread>) {
        for (thread in threads) {
            try {
                thread.join()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
        threads.clear()
    }
}