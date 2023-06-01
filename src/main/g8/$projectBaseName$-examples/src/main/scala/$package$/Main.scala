package $package$


/**
  * With the example plugin, a logging interceptor will appear around
  * every method application in this method.
  *
  */
def repeat_prime(s: String, i: Int): String =
  val stringBuilder = java.lang.StringBuilder()
  var x = 0
  while (x < i)
    stringBuilder.append(s)
    x = x + 1
  stringBuilder.toString()


/**
  * With the example plugin, a logging interceptor will appear around
  * every method application in this method. main will not be
  * affected.
  *
  * When run, this will print (sbt output formatting):
  * {{{
  *  root> $projectBaseName$-examples / run 
  *  [info] $package$.main called
  *  [info] java.lang.String.+ called with Batman!
  *  [info] $package$.repeat_prime called with Na , 8
  *  [info] java.lang.StringBuilder.<init> called
  *  [info] scala.Int.< called with 8
  *  [info] java.lang.StringBuilder.append called with Na 
  *  [info] scala.Int.+ called with 1
  *  [info] scala.Int.< called with 8
  *  [info] java.lang.StringBuilder.append called with Na 
  *  [info] scala.Int.+ called with 1
  *  [info] scala.Int.< called with 8
  *  [info] java.lang.StringBuilder.append called with Na 
  *  [info] scala.Int.+ called with 1
  *  [info] scala.Int.< called with 8
  *  [info] java.lang.StringBuilder.append called with Na 
  *  [info] scala.Int.+ called with 1
  *  [info] scala.Int.< called with 8
  *  [info] java.lang.StringBuilder.append called with Na 
  *  [info] scala.Int.+ called with 1
  *  [info] scala.Int.< called with 8
  *  [info] java.lang.StringBuilder.append called with Na 
  *  [info] scala.Int.+ called with 1
  *  [info] scala.Int.< called with 8
  *  [info] java.lang.StringBuilder.append called with Na 
  *  [info] scala.Int.+ called with 1
  *  [info] scala.Int.< called with 8
  *  [info] java.lang.StringBuilder.append called with Na 
  *  [info] scala.Int.+ called with 1
  *  [info] scala.Int.< called with 8
  *  [info] java.lang.StringBuilder.toString called
  *  [info] scala.Predef.println called with Na Na Na Na Na Na Na Na Batman!
  *  [info] java.lang.String.+ called with Batman!
  *  [info] $package$.repeat_prime called with Na , 8
  *  [info] java.lang.StringBuilder.<init> called
  *  [info] scala.Int.< called with 8
  *  [info] java.lang.StringBuilder.append called with Na 
  *  [info] scala.Int.+ called with 1
  *  [info] scala.Int.< called with 8
  *  [info] java.lang.StringBuilder.append called with Na 
  *  [info] scala.Int.+ called with 1
  *  [info] scala.Int.< called with 8
  *  [info] java.lang.StringBuilder.append called with Na 
  *  [info] scala.Int.+ called with 1
  *  [info] scala.Int.< called with 8
  *  [info] java.lang.StringBuilder.append called with Na 
  *  [info] scala.Int.+ called with 1
  *  [info] scala.Int.< called with 8
  *  [info] java.lang.StringBuilder.append called with Na 
  *  [info] scala.Int.+ called with 1
  *  [info] scala.Int.< called with 8
  *  [info] java.lang.StringBuilder.append called with Na 
  *  [info] scala.Int.+ called with 1
  *  [info] scala.Int.< called with 8
  *  [info] java.lang.StringBuilder.append called with Na 
  *  [info] scala.Int.+ called with 1
  *  [info] scala.Int.< called with 8
  *  [info] java.lang.StringBuilder.append called with Na 
  *  [info] scala.Int.+ called with 1
  *  [info] scala.Int.< called with 8
  *  [info] java.lang.StringBuilder.toString called
  *  [info] Na Na Na Na Na Na Na Na Batman!
  *  }}}
  *
  */
@main def main(): Unit =
  println(repeat_prime("Na ", 8) + "Batman!")
