class Person(val firstName:String = "A", val lastName:String="B"){

    init {
        println("init 1")
    }

    //secondary constructor
//    constructor(): this("C","D"){
//        println("seconday const")
//    }
    init {
        println("init 2") // 모두 실행된다.
    }

    var nickName: String? = null

        // overriding default set, get
        set(value) {
            field = value
            println("new nickname is $value")
        } // function when set is called
        get() {
            return field
        }

    fun printInfo() {
//        val nickToPrint = if (nickName!=null) nickName else "No nickname"
        val nickToPrint = nickName ?: "no nickname"
        println("$firstName ($nickToPrint) $lastName")
    }
}