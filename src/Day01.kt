fun numIncreasing(values: List<Int>) : Int {
    return (values zip values.drop(1)).filter { it -> it.second > it.first }.size
}

fun part1(input: List<Int>) {
    println(numIncreasing(input))
}

fun part2(input: List<Int>) {
    println(numIncreasing(input.windowed(size=3).map { it.sum() }))
}
fun main() {
    val input: List<Int> = readInput("Day01").map { it.toInt() }
    part1(input)
    part2(input)
}