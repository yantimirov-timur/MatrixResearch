package coroutins_sandbox

import kotlinx.coroutines.*
import java.lang.Math.sin

fun factorial(n: Int): Int {
    return if (n == 0) {
        1
    } else {
        n * factorial(n - 1)
    }
}

fun main(): Unit = runBlocking {
    val a = launch { doComm() }
    println(a)
}

suspend fun doComm(): Int {
    val n1 = factorial(10)
    val n2 = factorial(9)


    return n1 * n2
}

// Concurrently executes both sections
suspend fun doWorld() = coroutineScope { // this: CoroutineScope
    var n1 = 0
    var n2 = 0

    launch {
        // delay(1000L)
        //println(sin(30.0))
        n1 = factorial(10)
    }
    launch {
        n2 = factorial(14)
//        delay(10000L)
//        println()
    }
}