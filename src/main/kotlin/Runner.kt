import matrix.MatrixBuilder
import multiplication.MatrixMultiplier
import multiplication.multiplyConcurrently
import java.util.Date

suspend fun main(args: Array<String>) {
    val start = Date().time
    val matrixNumRange = 10
    val matrixSize = args[1].toInt()
    val matrixA = MatrixBuilder(matrixSize, matrixSize).buildMatrix(matrixNumRange)
    val matrixB = MatrixBuilder(matrixSize, matrixSize).buildMatrix(matrixNumRange)
    val res = MatrixBuilder(matrixSize, matrixSize).buildMatrix(0)
    val numCores = Runtime.getRuntime().availableProcessors()
    val numThreads = args[2].toInt()
    when (args[0]) {
        "-m" -> {
            ParallelThreadsCreator.multiply(matrixA, matrixB, res, numThreads)
            println("Mode: Multi thread")
            println("Num of threads: $numThreads")
        }
        "-t" -> {
            MatrixMultiplier().multiply(matrixA, matrixB)
            println("Mode: One thread")
        }
        "-c" -> {
            multiplyConcurrently(matrixA, matrixB, res)
            println("Mode: Coroutines")
            println("Num of coroutines = size of matrix")
        }
        "-o" -> {
            ParallelThreadsCreator.multiply(matrixA, matrixB, res, numCores)
            println("Mode: Optimized num of threads")
            println("Num of threads: $numCores")
        }

        else -> println("Unknown operation")
    }

    val end = Date().time
    val diff = (end - start)
    println("Elapsed milliseconds: $diff")
    println("Size of matrix: $matrixSize")

}