fun greet(greeting: String, itemsToGreet: List<String>) {
    itemsToGreet.forEach {
        println("$greeting $it")
    }
}

fun main() {
    val interestingThings = arrayOf("K","P","CB")
    interestingThings.plus("K")
    println(interestingThings.size)
    println(interestingThings[0])
    println(interestingThings.get(0))

    for (interestingThing in interestingThings) {
        println(interestingThing)
    }

    interestingThings.forEach { interestingThing ->
        println(interestingThing)
    }

    interestingThings.forEachIndexed { index, interest ->
        println("$interest is at $index")
    }

    val lst = listOf("K", "P", "CB")
    val lst2 = mutableListOf("K","A")
    lst2.add("D")
    lst.forEach { interest ->
        println(interest)
    }

    val map = mapOf(1 to "a", 2 to "b", 3 to "c")
    val map2 = mutableMapOf(1 to "a")
    map2.put(4,"d")

    map.forEach { key, value ->
        println("$key -> $value")
    }
    greet("Hi",lst)
}



