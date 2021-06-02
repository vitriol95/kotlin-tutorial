val a: String? = null
val name: String = "Me"
var greeting: String? = "Hello"

fun main() {

    if (greeting != null) {
        println(greeting)
    }

    when (greeting) {
        null -> println("Hi")
        "Me" -> println("FF")
        else -> println(greeting)
    }

    val greetingToPrint = if (greeting != null) greeting else "Hi"
    val greeting2 = when (greetingToPrint) {
        null -> "Me"
        else -> "Go"
    }
}