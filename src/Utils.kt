import java.io.File

fun readInput(path: String) = File("src/input", "$path.txt").readLines()