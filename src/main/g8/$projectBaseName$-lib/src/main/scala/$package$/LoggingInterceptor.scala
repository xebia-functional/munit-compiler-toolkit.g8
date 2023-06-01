package $package$

import scala.util.Try

/**
  * An example logging utility that logs the name and arguments to a
  * method or function call. It is inserted around calls to non
  * constructor methods by the transformation in the
  * $package$.$projectPluginClassName$Phase as part of the
  * $package$.$projectPluginClassName$ plugin.
  *
  * This is included as an example of how to use a library in a
  * compiler plugin. You will undoubtably remove it and replace it
  * with your own library code.
  *
  */ 
class LoggingInterceptor[A](intercepted: => A):
  def apply(name: String): A = 
    println(s"$name called")
    val result = Try(intercepted)
    result.get
  def apply(name: String)(arguments: Any*): A = 
    println(s"$name called with ${arguments.map(_.toString).mkString(", ")}")
    val result = Try(intercepted)
    result.get

