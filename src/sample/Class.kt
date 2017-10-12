package sample

// 継承許可はopenをつける
open class Car(val name: String) {
    open fun show() {
        println("Car name=${name}")
    }
}

class Toyota(val id: Long, name: String): Car(name) {    // ToyotaのnameをCarに渡している（javaのsuper
    override fun show() {
        println("Toyota car id:$id name=$name") // spaceなどで区切れる場合は{}無くても大丈夫
    }
}

// コンストラクタとバッキングフィールドを別にする場合
class Person(_name: String) {
    var name: String = _name
        get() { return field }  // fieldはバッキングフィールドを表す暗黙的変数
        set(value) { field = value }
    val initial: Char
        get() = name[0]
}

abstract class Greeter {

    abstract val name: String

    open fun sayHello() {
        println("Hello")
    }
    abstract fun sayGoodbye()
    abstract fun introduceMyself()
}

class JapaneseGreeter(override val name: String): Greeter() {  // 継承の宣言でも()がいるのがポイントなのかもしれない
    override fun sayHello() {
        println("こんにちは")
    }

    override fun sayGoodbye() {
        println("さようなら")
    }

    override fun introduceMyself() {
        println("私は${name}です")
    }
}

// IFはバッキングフィールドを持つプロパティを定義できない
interface GreeterIF {
    fun sayHello()
}

// classをobjectにするとシングルトンになる
class EnglishGreeter: GreeterIF {   // IFの場合は()がいらない
    override fun sayHello() {   // openやabstractはいらなくてもoverrideはいる
        println("Hello")
    }
}

interface IFA {
    fun foo() { println("A") }
}
interface IFB {
    fun foo() { println("B") }
}
class DuplicatedMethod: IFA, IFB {
    override fun foo() {
        super<IFA>.foo()    // IFAのを使いたい場合
    }
}

fun main(args: Array<String>) {

    val supra = Toyota(1L, "スープラ")
    supra.show()

    val hanako = Person("Hanako")
    hanako.name = "花子"
    println(hanako.name)
    println(hanako.initial)

    val greeter = JapaneseGreeter("太郎")
    greeter.sayHello()
    greeter.introduceMyself()
    greeter.sayGoodbye()

    val man = EnglishGreeter()  // objectの場合は()いらない
    man.sayHello()
}