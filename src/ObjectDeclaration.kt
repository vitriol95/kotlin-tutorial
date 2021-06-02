import java.util.*

enum class EntityType {

    HELP, EASY, MEDIUM, HARD;

    fun getFormattedName() = name.toLowerCase().capitalize()
}

object EntityFactory {

    fun create(type: EntityType): Entity2 {
        val id = UUID.randomUUID().toString()
        val name = when (type) {
            EntityType.EASY -> type.name // name of actual Enum Class (Capital Letters)
            EntityType.MEDIUM -> type.getFormattedName()
            EntityType.HARD -> "Hard"
            EntityType.HELP -> type.getFormattedName()
        }
        return Entity2(id, name)
    }

    fun createSealedClass(type: EntityType): Entity3 {

        val id = UUID.randomUUID().toString()
        val name = when (type) {
            EntityType.EASY -> type.name // name of actual Enum Class (Capital Letters)
            EntityType.MEDIUM -> type.getFormattedName()
            EntityType.HARD -> "Hard"
            EntityType.HELP -> type.getFormattedName()
        }

        return when (type) {
            EntityType.EASY -> Entity3.Easy(id,name)
            EntityType.MEDIUM -> Entity3.Medium(id,name)
            EntityType.HARD -> Entity3.Hard(id,name,2f)
            EntityType.HELP -> Entity3.Help
        }
    }
}

class Entity2(val id: String, val name:String){

    override fun toString(): String {
        return "id: $id name: $name"
    }
}

sealed class Entity3(){

    object Help : Entity3() {
        val name = "Help"

    }

    // sealed class with Different types of properties
    data class Easy(val id:String, val name:String): Entity3(){

        override fun equals(other: Any?): Boolean {
            return super.equals(other)
        }

        override fun hashCode(): Int {
            return super.hashCode()
        }
    }
    data class Medium(val id: String, val name: String) : Entity3()
    data class Hard(val id: String, val name: String, val multiplier: Float) : Entity3()
}

fun Entity3.Medium.printInfo() { // 약간 자바스크립트 처럼 이렇게 외부에서 함수를 추가해줄 수 있음.
    println("Medium class:$id")
}

val Entity3.Medium.info: String
    get() = "some Info"

fun main() {
    var entity = EntityFactory.create(EntityType.EASY)
    println(entity)

    val mediumEntity = EntityFactory.create(EntityType.MEDIUM)
    println(mediumEntity)
    println("===============")

    val sealed: Entity3 = EntityFactory.createSealedClass(EntityType.HELP)

    val msg = when (sealed) {
        Entity3.Help -> "help class" // singleton
        is Entity3.Easy -> "easy class" // is -> instance or not
        is Entity3.Medium -> "medium class"
        is Entity3.Hard -> "hard class"
    }

    println(msg)

    println("===============")

    // Data classes
    val entity1 = EntityFactory.createSealedClass(EntityType.EASY)
    val entity2 = EntityFactory.createSealedClass(EntityType.EASY)

    println(entity1 == entity2) // false
    println(entity1 === entity2) // false

    // how bout this one?
    val entity3 = Entity3.Easy("id", "name")
    val entity4 = Entity3.Easy("id","name")
    println(entity3 == entity4) // true
    println(entity3 === entity4) // false

    val entity4_copied = entity4.copy()
    println(entity4 == entity4_copied) // true
    println(entity4 === entity4_copied) // false
    // 카피한것과 만든것의 결과가 같음. 어찌보면 당연하다 메모리는 다르기 때문에 ===는 false가 된다. (ref가 다르다)

    println("===============")
    // 하지만 다음이 가능하다.
    val entity5 = entity4.copy(name = "new name")
    println(entity4 == entity5) // false
    println(entity4 === entity5) // false

    println("===============")
    Entity3.Medium("id", "name").printInfo()

    println("===============")
    val entity_medium = EntityFactory.createSealedClass(EntityType.MEDIUM)
    if (entity_medium is Entity3.Medium) {
        entity_medium.printInfo()
        entity_medium.info // Extension func as Property
    }
}