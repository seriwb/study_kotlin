package sample.other

interface Greeter {
    val name: String
    fun introduceMySelf()
    fun sayHello()
}

class EnglishGreeter(override val name: String): Greeter {

    override fun introduceMySelf() {
        sayHello()
        println("I am $name")
    }

    override fun sayHello() {
        println("Hello")
    }
}

// デリゲートでEnglishGreeterを利用するクラスを実装
class CountingGreeter(private val greeter: Greeter): Greeter by greeter {

    // 未実装のメソッドはパラメータのgreeterのクラスに丸投げ

    var helloCount: Int = 0
        private set

    override fun sayHello() {
        helloCount++
        greeter.sayHello()
    }
}

fun main(args: Array<String>) {

    val man = EnglishGreeter("Tom")
    val shadow = CountingGreeter(man)

    man.sayHello()
    println(shadow.helloCount)
    shadow.sayHello()
    println(shadow.helloCount)
}