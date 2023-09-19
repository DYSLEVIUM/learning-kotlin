fun main() {
    val list = (1..20).toList()
    println("list is $list")

    // lambda
    val oddList = list.filter { item -> item.and(1) == 1 }
    val evenList = list.filter { it.and(1) == 0 }
    println("oddList is $oddList")
    println("evenList is $evenList")

    val circle1 = Circle.makeCircle(10.0, "Circle1")
    val circle2 = Circle.makeCircle(20.0, "Circle2")
    val rect1 = Rectangle(10, 20)
    val rect2 = Rectangle(10, 50)
    val rect3 = Rectangle(10.0)

    println()

    var shapes = listOf(circle1, circle2, rect1, rect2, rect3)
    shapes = shapes.filter { it.getArea() > 20 }.sortedBy { it.getArea() }.sortedBy { it.name }.reversed()
    for (shape in shapes) {
        println("${shape.name}: Area: ${shape.getArea()}")
    }

    println()

    shapes = shapes.customFilter { it.getArea() > 20 }.sortedBy { it.getArea() }.sortedBy { it.name }.reversed()
    for (shape in shapes) {
        println("${shape.name}: Area: ${shape.getArea()}")
    }

    val ints = (1..10).toList().customFilter { it>5 }
    val triple = Triple<Int, String, Boolean>(3, "hello", true)
    val customTriple = CustomTriple<Int, String, Boolean>(3, "hello", true)
    customTriple.printTypes()
}

// extension
// The in keyword is used to specify that a generic type is an "input" type, meaning it will only be used as an argument to a function or a class.
// The out keyword is used to specify that a generic type is an "output" type, meaning it will only be used as a return type from a function or a class.
// The where keyword is used to specify constraints on the types that can be used as arguments or return types.

//fun List<Shape>.customFilter(filterFunction: (Shape)->Boolean): List<Shape> {
//fun <T> List<T>.customFilter(filterFunction: (T)->Boolean): List<T> {
//fun <T: Shape> List<T>.customFilter(filterFunction: (T)->Boolean): List<T> {
fun <T> List<T>.customFilter(filterFunction: (T)->Boolean): List<T> where T: Any {
    // val resultList = mutableListOf<Shape>()
    val resultList = mutableListOf<T>()
    for (element in this) {
        if (filterFunction(element)) {
            resultList.add(element)
        }
    }

    return resultList
}