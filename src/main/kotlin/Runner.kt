import matrix.MatrixBuilder
import multiplication.MatrixMultiplier
import java.util.*

fun main(args: Array<String>) {
    val start = Date().time

    val matrixSize = args[1].toInt()
    val matrixA = MatrixBuilder(matrixSize, matrixSize).buildMatrix(10)
    val matrixB = MatrixBuilder(matrixSize, matrixSize).buildMatrix(10)
    val res = MatrixBuilder(matrixSize, matrixSize).buildMatrix(0)

    when (args[0]) {
        "-m" -> {
            ParallelThreadsCreator.multiply(matrixA, matrixB, res)
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



    println("Size of matrix: $matrixSize")
    println("Elapsed milliseconds: $diff")
}