import java.lang.NumberFormatException

fun main() {
    // exceptions
    print("Please enter a number: ")
    val input = try {
        readlnOrNull()?.toInt()
    } catch (e: NumberFormatException) {
        -1
    } finally {
        println("Conversion done!")
    }
    println("You entered: $input")

    println(divide(10.0,0.1))
}

class DivideByZeroException: Exception("Divide by 0")

fun divide(a: Double, b: Double): Double {
    if (b == 0.0) throw DivideByZeroException()
    return a / b
}