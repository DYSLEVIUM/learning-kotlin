import kotlin.math.sqrt
import kotlin.random.Random

// suspend
// Suspending functions can be created as standard Kotlin functions, but we need to be aware that we can only call them from within a coroutine. Otherwise, we’ll get a compiler error.
//
// If we’ve suspended the call within the buildSequence, that call will be transformed to the dedicated state in the state machine.

// lateinit
// We may not want to initialize our values at declaration time, but instead want to initialize and use them at any later time in our application. However, before using our value, we must not forget that our value must be initialized before it can be used.
// But what if we tried to print our value to LogCat without initializing it? if we try to access our value without initializing it, we will encounter a “UninitializedPropertyAccessException” exception. To avoid this error, we can also use the isInitialized() method that Kotlin provides for us

// by lazy
// Lazy initialization is a design pattern that we often come across in the software world. With lazy initialization, we can create objects only the first time that we access them, otherwise we don’t have to initialize them. It ensures that objects that are expensive to create are initialized only where they are to be used, not on the app startup.
//
// lazy in Kotlin is useful in a scenario when we want to create an object inside a class, but that object creation is expensive and that might lead to a delay in the creation of the object that is dependent on that expensive object. So, we need to understand that the object will get initialized only when it is accessed for the first time, else it will not get initialized.

// data class
// The data class in Kotlin is used to hold the data. This data class contains some utility functions that are often derivable from the data. 
//
// With the help of the data class, you don’t need to write the boiler plate code. The compiler automatically generates all the getter and setter for all the data class properties.
// The data class includes some inbuilt functions, and due to these functions, you don’t need to write the boiler plate code. Following are those functions:
// toString()
// copy()
// equals()
// hashCode()

// Scope functions
// The Kotlin standard library contains several functions whose sole purpose is to execute a block of code within the context of an object. When you call such a function on an object with a lambda expression provided, it forms a temporary scope. In this scope, you can access the object without its name. Such functions are called scope functions. There are five of them: let, run, with, apply, and also.

fun main() {
    // val is runtime constant whereas const val is compile-time constant; also val and var can be assigned a function but not const val

    val st = if(Random.nextInt() < Random.nextInt()) 1 else 2
    val ed = 20
    for(i in ed downTo st step 2) {
        println(i)
    }
    println()
    for(i in st..ed step 2) {
        println(i)
    }

    // array have constant size but are mutable, lists are immutable
    // mutable List are mutable and have variable size

    // when
    // val age = readlnOrNull()?.toInt()
    val age = Random.nextInt(0, 100)

    when(age) {
        in 0..5 -> println("You are young!")
        in 6..17 -> println("You are a teenager!")
        18 -> println("Finally, you are 18!")
        19, 20 -> println("You are a young adult!")
        in 21..65 -> println("You are an adult")
        else -> println("You are very old!")
    }

    val x = if(Random.nextInt() < Random.nextInt()) 10 else "string"

    when(x) {
        is String -> println("String")
        is Int -> println("Integer")
    }

    val intArr = intArrayOf(10,24,51)
    val listArr = listOf(51,616,61)
    val max = getMax(1,2,3,4,5, *intArr, *listArr.toIntArray())
    println("Max is $max")

    // function extensions
    println(2.even())
    println(2.odd())
    println(3.even())
    println(3.odd())
    println("3 is prime ${3.prime()}")
    println("4 is prime ${4.prime()}")
    println("107 is prime ${107.prime()}")

    val rect = Rectangle(20, 10)
    println("The area of the rectangle is ${rect.getArea()}")
    println("The perimeter of the rectangle is ${rect.getPerimeter()}")

    val circle = Circle.makeCircle(10.0, "Circle C")
    println("The area of the circle is ${circle.getArea()}")
    println("The perimeter of the circle is ${circle.getPerimeter()}")

    val sideLen = 3.0
    val slantLen = 4.0
    val height = 2.0

    // anonymous class
    val parallelogram = object : Shape("Parallelogram", sideLen, slantLen, height) {
        init {
            println("$name created")
        }

        override fun getArea(): Double = sideLen * height

        override fun getPerimeter(): Double = 2 * (sideLen + slantLen)
    }

    println("The area of the parallelogram is ${parallelogram.getArea()}")
    println("The perimeter of the parallelogram is ${parallelogram.getPerimeter()}")

}

// vararg
fun getMax(vararg numbers : Int = intArrayOf(-1)) : Int {
    var max = numbers[0]
    for(number in numbers) {
        max = if(max < number) number else max
    }
    return max
}

// extensions
fun Int.prime() : Boolean {
    //for (i in 2 until sqrt(this.toDouble()).toInt()) {
    for (i in 2..sqrt(this.toDouble()).toInt()) {
        if (this % i == 0) return false
    }
    return true
}

fun Int.odd() : Boolean = this.and(1) == 1

fun Int.even() : Boolean = !this.odd()
