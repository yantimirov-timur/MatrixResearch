package matrix

fun printMatrix(matrix: Array<Array<Int>>) {
    for (element in matrix) {
        for (j in matrix.indices) {
            val a = element[j]
            print("$a  ")
        }
        println()
    }
}
