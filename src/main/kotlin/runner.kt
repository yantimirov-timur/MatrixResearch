import matrix.MatrixBuilder
import multiplication.MatrixMultiplier
import java.util.*

fun main() {
    val start = Date().time

    val matrixSize = 3000
    val matrixA = MatrixBuilder(matrixSize, matrixSize).buildMatrix(10)
    val matrixB = MatrixBuilder(matrixSize, matrixSize).buildMatrix(10)
//    printMatrix(matrixA)
//    println()
//    printMatrix(matrixB)
//    println()
    val matrixMultiplication = MatrixMultiplier()
    val resMatrix = matrixMultiplication.multiply(matrixA, matrixB)
  //  printMatrix(resMatrix)
    val end = Date().time
    val diff = (end - start)

    println("Size of matrix: $matrixSize")
    println("Elapsed milliseconds: $diff")

//    //printMatrix(resMatrix)
//    val numThread = 2
//    val th = mutableListOf<Thread>()
//    for (i in 0..numThread) {
//        val tmpTh = Thread(MatrixMultiplierThread(matrixA, matrixB))
//        tmpTh.start()
//        th.add(tmpTh)
//    }
//    println(Thread.activeCount());
//    for (t in th) {
//        t.join()
//    }


}