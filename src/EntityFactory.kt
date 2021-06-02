interface IdProvider {
    fun getId():String
}

class Entity private constructor(val id: String){

    // Companion object can implement interface
    companion object Factory : IdProvider {

        override fun getId(): String {
            return "123"
        }

        const val id = "id"
        fun create() = Entity(getId())
    }

}

fun main() {

    // val entity = Entity("id") <-- disable cause of private Constructor
    val entity = Entity.create()
    val entity2 = Entity.Factory.create() // Same as above
    Entity.id
}