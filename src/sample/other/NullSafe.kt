package sample.other

fun main(args: Array<String>) {

    val ints: List<Int> = mutableListOf(1, 2, 3)
    if (ints is MutableList<Int>) {
        // スマートキャスト
        ints.add(4)     // (ints as MutableList<Int>).add(4)と同じ
    }

    val bar: String? = "Hello"
    if (bar != null) {
        // NotNullが確定していればメソッドを呼び出せる
        println(bar.toUpperCase())
    }

    // 矯正的にNotNullにする
    println(bar!!.toUpperCase())

    val baz: String? = null
    // 安全呼び出し（変数がnullの場合、nullが返る）
    println(baz?.toUpperCase())
    // エルビス演算子
    println(baz?.toUpperCase() ?: "default")
}