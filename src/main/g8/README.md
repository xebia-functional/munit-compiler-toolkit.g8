# $name;format="lower,hyphen"$

$description

## Project Structure

The build is a normal [sbt](https://www.scala-sbt.org/) build. The
project has three subprojects:

* $name;format="lower,hyphen"$-lib
  
  The library code referenced within the compiler transformations.

* $name;format="lower,hyphen"$-plugin

  The plugin code itself. Depends on $name;format="lower,hyphen"$-lib
  and the scala 3 compiler. Uses
  [munit-compiler-toolkit-testkit](https://github.com/xebia-functional/sbt-munit-compiler-toolkit)
  for unit and integration tests, and
  [munit-snap](https://github.com/xebia-functional/munit-snap) for
  integration tests. Project configuration to use the main compiler
  source code is provided by
  [sbt-munit-compiler-toolkit](https://github.com/xebia-functional/sbt-munit-compiler-toolkit).

* $name;format="lower,hyphen"$-example

  A project demonstrating the compiler plugin. Contains fully compiled
  use-case demonstractions of $name;format="lower,hyphen"$-plugin.

## Included Sbt Plugins

