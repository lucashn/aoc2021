fun main() {
    fun mostCommon(list: List<Char>): Char {
        val zeroes = list.count { it == '0' }
        val ones = list.size - zeroes

        return if (zeroes > ones)
            '0'
        else if (ones > zeroes)
            '1'
        else
            't'
    }

    fun part1(input: List<String>) {
        val bits = mutableListOf<Char>()

        // get the most common bit for each column
        for (colIndex in input[0].indices) {
            val colValues = input.map { it[colIndex] }
            bits += mostCommon(colValues)
        }

        // bit to decimal
        val gamma = bits.joinToString("").toInt(2)
        val epsilon = bits.map { if (it == '0') 1 else 0 }.joinToString("").toInt(2)
        println(gamma * epsilon)
    }

    fun part2(input: List<String>) {
        fun iterativeFilter(input: List<String>, predicate: (Char) -> Char) : Int {
            var list = input.toList()
            val range = list[0].indices

            for(colIndex in range) {
                if(list.size == 1) {
                    break
                }
                val colValues = list.map { it[colIndex] }
                val desired = predicate(mostCommon(colValues))
                list = list.filter { it[colIndex] == desired }
            }

            return list.single().toInt(2)
        }

        fun oxygenRating() : Int {
            return (iterativeFilter(input) {
                when (it) {
                    '0' -> '0'
                    '1' -> '1'
                    else -> '1'
                }
            })
        }

        fun scrubberRating() : Int {
            return (iterativeFilter(input) {
                when (it) {
                    '0' -> '1'
                    '1' -> '0'
                    else -> '0'
                }
            })
        }

        println(oxygenRating() * scrubberRating())
    }

    val input = readInput("Day03")
    part1(input)
    part2(input)
}