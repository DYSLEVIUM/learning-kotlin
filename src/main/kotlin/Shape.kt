import java.io.File
import javax.sql.DataSource

// abstract classes can have some functions definitions, but in interface all the functions don't have definition
abstract class Shape (
    var name: String
): IShape {
    constructor(name: String, vararg  dimensions: Double) : this(name)

    init {
        println("I am the super class for $name!")
    }

    abstract fun getPerimeter() : Double
}

// Sealed classes and interfaces represent restricted class hierarchies that provide more control over inheritance. All direct subclasses of a sealed class are known at compile time. No other subclasses may appear outside the module and package within which the sealed class is defined.
// In some sense, sealed classes are similar to enum classes: the set of values for an enum type is also restricted, but each enum constant exists only as a single instance, whereas a subclass of a sealed class can have multiple instances, each with its own state.
// As an example, consider a library's API. It's likely to contain error classes to let the library users handle errors that it can throw. If the hierarchy of such error classes includes interfaces or abstract classes visible in the public API, then nothing prevents implementing or extending them in the client code. However, the library doesn't know about errors declared outside it, so it can't treat them consistently with its own classes. With a sealed hierarchy of error classes, library authors can be sure that they know all possible error types and no other ones can appear later.
// A sealed class is abstract by itself, it cannot be instantiated directly and can have abstract members.
//
// Constructors of sealed classes can have one of two visibilities: protected (by default) or private:

sealed interface Error

sealed class IOError(): Error

class FileReadError(val file: File): IOError()
class DatabaseError(val source: DataSource): IOError()

object RuntimeError : Error