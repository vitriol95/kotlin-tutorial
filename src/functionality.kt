fun say(a: String, vararg b: String) {
    b.forEach {
        println("$a $it")
    }
}

fun sayPerson(greeting:String = "Hello", name: String? = "Kotlin") = println("$greeting $name")

fun main() {
    val arr = arrayOf("A","B","C")
    say("hi")
    say("hi","Kotlin","pro","comm")
    say("hi",*arr)

    sayPerson("hi","v")
    sayPerson(name = "V",greeting = "hi")
    sayPerson(name = null)
    sayPerson()

    say(a = "Hi",*arr)
}