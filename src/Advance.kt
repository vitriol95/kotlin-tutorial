// chaining
fun main() {
    val list = listOf("Kotlin", "Java", "C++", "Javascript",null)
    list
        .filterNotNull()
        .filter{
            it.startsWith("J")
        }
        .map {
            it.length
        }
        .forEach {
        println(it)
    }
    println("===================")
    list
        .filterNotNull()
        .take(3) // take First 3 things
        .forEach {
            println(it)
        }

    println("===================")
    list
        .filterNotNull()
        .takeLast(3) // take Last 3 things
        .forEach {
            println(it)
        }

    println("===================")
    list
        .filterNotNull()
        .associate { it to it.length }
        .forEach {
            println("${it.value},${it.key}")
        } // list to map

    println("===================")

    val map = list
        .filterNotNull()
        .associate { it to it.length } // 변수 할당 또한 가능.

    val language = list.filterNotNull().last()
    println(language) // Javascript

    //specific item
    val target = list.filterNotNull().find{ it.startsWith("Java")}.orEmpty() // 원래 조건에 만족하는 값이 없으면 null을 뱉으나, 이 경우에는 "" 라는 Empty String을 반환한다.
    println(target)

}