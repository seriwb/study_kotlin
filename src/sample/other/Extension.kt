package sample.other

// 拡張関数
fun Int.isOdd(): Boolean = (this % 2 != 0)

// 拡張プロパティ
val Int.isEven: Boolean
    get() = (this % 2 == 0)

fun main(args: Array<String>) {
    println(7.isOdd())
    println(8.isEven)
}