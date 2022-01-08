import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable
data class Digit(val name: String, val value: Int)

val digitMap = listOf(
    Digit("One", 1),
    Digit("Two", 2),
    Digit("Three", 3),
    Digit("Four", 4),
    Digit("Five", 5),
    Digit("Six", 6),
    Digit("Seven", 7),
    Digit("Eight", 8),
    Digit("Nine", 9),
    Digit("Zero", 0)
)

fun main(args: Array<String>) {
    println("The Result will be: ${sumInput("One-One-Two-Nine-Three-Zero")}")
}

fun sumInput(param1: String): Int {
    val digitStringList: List<String> = param1.split("-")
    var result = 0
    digitMap.forEach {
        result += checkDigitMap(it, digitStringList)
    }
    return result
}

fun checkDigitMap(digitString: Digit , inn: List<String>): Int {
    val longerThan3 = inn.filter {   s -> s == digitString.name }
    return longerThan3.count() * digitString.value
}
