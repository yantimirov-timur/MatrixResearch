import kotlinx.coroutines.*
import matrix.MatrixBuilder
import java.util.Date


fun multiplyRows(
    result: Array<Array<Int>>,
    matrixA: Array<Array<Int>>,
    matrixB: Array<Array<Int>>,
    row: Int
): Array<Array<Int>> {
    for (i in 0 until matrixB[0].size) {
        result[row][i] = 0
        for (j in 0 until matrixA[row].size) {
            result[row][i] += matrixA[row][j] * matrixB[j][i]
        }
    }
    return result
}

suspend fun multiplyConcurrently(
    matrixA: Array<Array<Int>>,
    matrixB: Array<Array<Int>>,
    result: Array<Array<Int>>,
) = coroutineScope {
    val rows = matrixA.size
    for (i in 0 until rows) {
        launch {
            multiplyRows(result, matrixA, matrixB, i)
        }

    }
}

suspend fun main() {
    val start = Date().time
    val size = 1000
    val m1 = MatrixBuilder(size, size).buildMatrix(10)
    val m2 = MatrixBuilder(size, size).buildMatrix(10)
    val r = MatrixBuilder(size, size).buildMatrix(0)
    multiplyConcurrently(m1, m2, r)
    val end = Date().time
    println(end - start)
}
