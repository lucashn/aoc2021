fun part1(input: List<List<String>>) {
    var horizontal = 0
    var depth = 0

    for( (op, arg) in input) {
        val nbr = arg.toInt()

        when(op) {
            "forward" -> horizontal += nbr
            "down" -> depth += nbr
            "up" -> depth -= nbr
        }
    }

    println(horizontal * depth)
}

fun part2(input: List<List<String>>) {
    var horizontal = 0
    var depth = 0
    var aim = 0

    for( (op, arg) in input) {
        val nbr = arg.toInt()

        when(op) {
            "forward" -> {
                horizontal += nbr
                depth += aim * nbr
            }
            "down" -> aim += nbr
            "up" -> aim -= nbr
        }
    }

    println(horizontal * depth)
}
fun main() {
    val input = readInput("Day02").map{ it.split(" ") }
    part1(input)
    part2(input)
}