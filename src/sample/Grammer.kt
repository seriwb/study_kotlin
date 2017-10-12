package sample

fun main(args: Array<String>) {
    println("Hello, world!")

    val str: String
    //str.isBlank() // 初期化前は当然呼べない
    str = "hoge"    // valの初期化を別にもできる
    println(str)    // 初期化してないとエラーになる

    // 配列定義あれこれ
    val laterInts: Array<Int> = arrayOf(1, 2, 3)
    val fasterInts: IntArray = intArrayOf(1, 2, 3)  // リテラル
    laterInts.forEach { print(it) }
    fasterInts.forEach { print(it) }
    println()

    // when式
    val whenResult = when(3) {
        1 -> "one"
        in 2..5 -> "two..five"
        else -> "unknown"
    }
    println(whenResult)

    // こういう風に使うならJavaのlambdaの方がスマートかな・・・
    val score = 70
    when {
        score >= 30 -> {
            "30以上"
        }
        else -> {
            "30未満"
        }
    }.apply { println(this) }

    // 以下と未満
    for (i in 10 .. 100 step 10) {
        print("${i} ")
    }
    println()
    for (i in 10 until 100 step 10) {
        print("${i} ")
    }

}
