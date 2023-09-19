// can only make circle from the circle class only using the private constructor
class Circle private constructor(
    private val radius: Double,
    circleName: String
): Shape(circleName){
    init {
        println("$name created with radius = $radius using companion object.")
    }

    // basically a static function, just fancy name
    companion object {
        fun makeCircle(radius: Double, circleName: String) = Circle(radius, circleName)

    }

    override fun getPerimeter(): Double = 2 * CONSTANTS.PI * radius

    override fun getArea(): Double = CONSTANTS.PI * radius * radius
}