package $package$

import com.xebia.functional.munitCompilerToolkit.CompilerSuite
import dotty.tools.dotc.core.Contexts.Context
import munit.SnapshotSuite

class $projectPluginClassName$IntegrationSuite extends SnapshotSuite, CompilerSuite:

  snapshotTest("The example plugin should put a LoggingInterceptor around calls to methods"){
    given Context = compilerContext()
    val source = """|def example(s: String): String =
                    |  s
                    |object Thing{
                    |  val x = example("test")
                    |}
                    |""".stripMargin
    compileToStringTreeAndStringContext(source, Option("pickleQuotes"))
  }

end $projectPluginClassName$IntegrationSuite
