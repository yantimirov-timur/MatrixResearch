import matrix.MatrixBuilder
import multiplication.MatrixMultiplier
import java.util.Date

fun main(args: Array<String>) {
    val start = Date().time

    val matrixSize = args[1].toInt()
    val matrixA = MatrixBuilder(matrixSize, matrixSize).buildMatrix(10)
    val matrixB = MatrixBuilder(matrixSize, matrixSize).buildMatrix(10)
    val res = MatrixBuilder(matrixSize, matrixSize).buildMatrix(0)

    when (args[0]) {
        "-m" -> {
            ParallelThreadsCreator.multiply(matrixA, matrixB, res, args[2].toInt())
            println("Mode: Multi thread")
        }
        "-t" -> {
            val matrixMultiplication = MatrixMultiplier()
            matrixMultiplication.multiply(matrixA, matrixB)
            println("Mode: One thread")
        }
        else -> println("Unknown operation")
    }

    val end = Date().time
    val diff = (end - start)

    println("Elapsed milliseconds: $diff")
    println("Num of threads: ${args[2]}")
    println("Size of matrix: $matrixSize")

}