// higher order function
fun printFilteredStrings(list: List<String>, predicate: ((String) -> Boolean)?) { // 뒤 predicate 인자는 argument와 return타입만을 지정

    list.forEach {
        if (predicate?.invoke(it) == true) { // null check!!
            println(it)
        }
    }
}

val predicate: (String) -> Boolean = {
    it.startsWith("J")
} // 이렇게 한줄 람다식을 만들어서 전달할 수도 있다.!! Store Function as Variable


fun getPrintPredicate(): (String) -> Boolean {
    return {it.startsWith("J")}
} // 함수가 함수를 리턴하는 것도 가능하다.

fun main() {
    val list = listOf("Kotlin","Java","C++","Javascript")
    printFilteredStrings(list, {it.startsWith("J")})
    println("=================================")

    // 또는 람다식을 쓸 수 있음.
    printFilteredStrings(list) {
        it.startsWith("K")
    }
    
    println("=================================")
    printFilteredStrings(list,null)

    println("=================================")
    printFilteredStrings(list, predicate)
    printFilteredStrings(list, getPrintPredicate()) // 둘다 동일하게 작동한다.
}