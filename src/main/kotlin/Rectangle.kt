// as the class has the open keyword, this indicates that the class can be inherited
open class Rectangle ( // primary constructor
    private val sideA: Double,
    private val sideB: Double
): Shape("Rectangle") {
    // secondary constructors; they should have unique declarations
    constructor(sideA: Double): this(sideA, sideA)
    constructor(sideA: Int, sideB: Int) : this(sideA.toDouble(), sideB.toDouble()) {
        println("$name of int constructor called.")
    }

    // is called when the object is created, then the secondary constructor body is called
    init {
        println("$name created with sideA = $sideA and sideB = $sideB")
    }

    override fun getPerimeter() = sideA + sideB

    override fun getArea(): Double = sideA * sideB
}