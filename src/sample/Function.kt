package sample

fun succ(n: Int): Int = n + 1

fun twice(n: Int, f: (Int) -> Int): Int = f(f(n))

fun contains(ints: List<Int>, predicate: (Int) -> Boolean): Boolean {
    ints.forEach { i ->
        if (predicate(i))
            return true
    }
    return false
}

fun isGraterThan5(n: Int): Boolean = 5 < n
fun isMultipleOf3(n: Int): Boolean = n % 3 == 0

fun main(args: Array<String>) {
    val myFunction = ::succ
    // val myFunction: (Int) -> Int = ::succ
    val got = myFunction(5)
    println(got)

    println(twice(5, ::succ))

    // 指定した条件に合う数が含まれているかをチェック
    println("2, 4, 6 is grater than 5? : ${contains(listOf(2, 4, 6), ::isGraterThan5)}")
    println("7, 5, 4 is multiple of 3? : ${contains(listOf(7, 5, 4), ::isMultipleOf3)}")

    println(contains(listOf(2, 4, 6), {5 < it }))
    println(contains(listOf(7, 5, 4), {n -> n % 3 == 0}))
    println(contains(listOf(7, 5, 4), fun(n) = n % 3 == 0))     // 無名関数バージョン

    println(sum((1..10).toList()))
    val checks: IntArray = intArrayOf(2, 11, 20, 12, 3)
    println(max(12, *checks))
}

// 末尾再帰とその最適化（TCO）: tailrec
fun sum(ints: List<Int>): Int {
    tailrec fun go(ints: List<Int>, acc: Int): Int =
            if (ints.isEmpty()) acc
            else go(ints.drop(1), acc + ints.first())
    return go(ints, 0)
}

// 可変長引数: vararg
fun max(n: Int, vararg ints: Int): Int {
    var max = n
    ints.forEach { if (max < it) max = it }
    return max
}
