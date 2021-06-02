
fun main() {

    val person = Person()
    println(person.firstName) // No Getter, Setter
    println(person.lastName)

    person.nickName = "S" // setter
    person.nickName = "AAA"

    println(person.nickName)

    person.printInfo()


}