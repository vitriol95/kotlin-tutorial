interface PersonInfoProvider {

    val providerInfo : String

    // can implement default!! woa!!
    fun printInfo(person: Person){
        println(providerInfo)
        person.printInfo()
    }
}

interface SessionInfoProvider {

    fun getSessionId() : String

}


open class BasicInfoProvider : PersonInfoProvider, SessionInfoProvider {

    override val providerInfo: String
        get() = "Basic Info Provider"

    protected open val sessionIdPrefix = "Session"

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("additional print statement")
    }

    override fun getSessionId(): String {
        return sessionIdPrefix
    }
}

fun main() {
    val provider = BasicInfoProvider()

    provider.printInfo(Person())
    provider.getSessionId()

    checkTypes(provider)
    println("=====================")

    val provider2 = FancyInfoProvider()
//    provider2.sessionIdPrefix  Protected!
    provider2.printInfo(Person())
}

// type casting
fun checkTypes(infoProvider: PersonInfoProvider) {
    if (infoProvider !is SessionInfoProvider) {
        println("not sessionInfoProvider")
    } else {
        println("is sessionInfoProvider")
//        (infoProvider as SessionInfoProvider).getSessionId() don't need to
        infoProvider.getSessionId() // smart cast
    }
}