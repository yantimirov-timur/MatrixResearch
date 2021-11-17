import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*




suspend fun main() = coroutineScope {
    val channel = Channel<Int>()
    launch {
        // this might be heavy CPU-consuming computation or async logic, we'll just send five squares
        for (x in 1..5)
            channel.send(x * x)
    }
// here we print five received integers:
    repeat(5) { println(channel.receive()) }
    println("Done!")
}