package $package$

import com.xebia.functional.munitCompilerToolkit.CompilerSuite
import dotty.tools.dotc.core.Contexts.Context


/**
  * An example generated CompilerSuite that will compile the string
  * source code using the $projectPluginClassName$ plugin and check
  * its output agains the expected output in the assertion after
  * $compilerPhaseBeforePluginPhase$.
  *
  * You will replace this with the tests for your plugin.
  * 
  */
class $projectPluginClassName$Suite extends CompilerSuite:

    compilerTest("The plugin should input the example plugin scala compiler classpath and transform this source correctly")(
    """|def example(s: String): String =
       |  s
       |object Thing {
       | val x = example("test")
       |}
       |""".stripMargin,
    Option("$compilerPhaseBeforePluginPhase$")
  ) { case (tree, given Context) =>
    assertEquals(
      cleanCompilerOutput(tree),
      """|package <empty> {
         |  final lazy module val Thing: Thing = new Thing()
         |  @SourceFile("compileFromStringscala") final module class Thing() extends Object() { this: Thing.type =>
         |    private def writeReplace(): AnyRef = new scala.runtime.ModuleSerializationProxy(classOf[Thing.type])
         |    val x: String = new com.example.compiler.plugins.LoggingInterceptor[String](example("test")).apply("example")(["test" : Any]*)
         |  }
         |  final lazy module val compileFromStringpackage:
         |    compileFromStringpackage = new compileFromStringpackage()
         |  @SourceFile("compileFromStringscala") final module class
         |    compileFromStringpackage() extends Object() {
         |    this: compileFromStringpackage.type =>
         |    private def writeReplace(): AnyRef =
         |      new scala.runtime.ModuleSerializationProxy(classOf[compileFromStringpackage.type])
         |    def example(s: String): String = s
         |  }
         |}""".stripMargin
    )
  }
end $projectPluginClassName$Suite
