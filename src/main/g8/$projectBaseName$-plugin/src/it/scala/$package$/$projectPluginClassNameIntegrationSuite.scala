package $package$

import munit.SnapshotSuite
import com.xebia.functional.munitCompilerToolkit.CompilerFixtures


//TODO: Add AutoDerivation to test suite class ; and compilerContextFixture  and
// def continuationsCompilerSnapshot(source: String)(using Context): (String, String) =
//     val p = Promise[(String, String)]
//     checkContinuations(source)((t, _) =>
//       p.complete(
//         Try(
//           (
//             compileSourceIdentifier.replaceAllIn(t.toString, ""),
//             compileSourceIdentifier.replaceAllIn(t.show, "")))))
// p.future.value.get.get
//to
//CompilerSuite in munit-compiler-toolkit-testkit for use here. 
class $projectPluginClassName$IntegrationSuite extends SnapshotSuite, CompilerFixtures, CompilerSuite:

  snapshotTest("The plugin should put a LoggingInterceptor around calls to methods"){
    
    given Context = compilerContext()

  }
