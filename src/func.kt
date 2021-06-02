// Single Expression Func
fun getGreeting() = "Hello Kotlin"

// Parameter
fun sayHello(greeting: String, itemToGreet:String) {
    val msg = "$greeting $itemToGreet"
    println(msg)
}

fun main() {
    println(getGreeting())
    sayHello("Hey","Kotlin")
}