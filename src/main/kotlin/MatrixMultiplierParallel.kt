import matrix.MatrixBuilder
import java.util.*

fun main() {
    val start = Date().time
    val size = 3000
    val m1 = MatrixBuilder(size, size).buildMatrix(10)
    val m2 = MatrixBuilder(size, size).buildMatrix(10)
    val res = MatrixBuilder(size, size).buildMatrix(0)


    val res_m = ParallelThreadsCreator.multiply(m1, m2, res)
   // printMatrix(res_m)
    val end = Date().time
    val diff = end - start
    println("Milliseconds elapsed: $diff")
}