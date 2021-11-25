package multiplication

import kotlinx.coroutines.*

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
        launch(Dispatchers.Default) {
            multiplyRows(result, matrixA, matrixB, i)
        }

    }
}

