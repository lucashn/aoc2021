val LOST = -1

fun parseInput(input: List<String>) : Pair<List<Int>, List<Array<IntArray>>> {
    val numbers = input[0].split(",").map { it.toInt() }
    val boards = input.drop(2).filter { line -> line.isNotBlank() }.chunked(5).map {
            chunk -> chunk.map{ txtLine -> txtLine.split(" ").filter{it.isNotBlank()}.map{it.toInt()}.toIntArray()}.toTypedArray()
    }

    return Pair(numbers, boards)
}

fun markBoard(board: Array<IntArray>, v: Int) {
    for(i in board.indices)
        for(j in board.indices)
            if(board[i][j] == v)
                board[i][j] = 0
}

fun checkBoard(board: Array<IntArray>) : Boolean {
    for(i in 0..4) {
        if (board[i].sum() == 0) return true // horizontal
        if(board.sumOf { it[i] } == 0) return true // vertical
    }

    return false
}

fun sumBoard(board: Array<IntArray>) = board.sumOf { it.sum() }

fun simulateBoard(board: Array<IntArray>, input: List<Int>) : Pair<Int, Int> {
    var moves = 0

    for(v in input) {
        markBoard(board, v)
        ++moves
        if(checkBoard(board))
            return Pair(moves, sumBoard(board) * v)
    }

    return Pair(LOST, LOST)
}

fun main() {
    val (numbers, boards) = parseInput(readInput("Day04"))
    val results = boards.map { simulateBoard(it, numbers) }.filter { it.first != LOST }.sortedBy { it.first }
    println("Part 1: " + results.first().second.toString())
    println("Part 2: " + results.last().second.toString())
}