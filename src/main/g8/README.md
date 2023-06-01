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

* [sbt-ci-release][sbtCiRelease]

    Provides ability to release to sonatype automatically.

* [sbt-github-actions][sbtGithubActions]

    Provides the ability to generate github actions to test and
    publish your project using sbt-ci-release. Follow the Readme
    instructions to set it up.
	
* [sbt-dependency-updates][sbtDependencyUpdates]

    Provides the ability to scan for dependency updates and update
    them automatically.
	
* [sbt-header][sbtHeader]

    Adds licensing headers to your project files. See its Readme for
    instructions on its use.
	
* [sbt-github][sbtGithub]

    Adds the ability to read github settings, necessary for publishing
    documentaition and other services dependent upon github. See its
    microsite for details.
	
* [sbt-github-mdoc][sbtGithubMdoc]

    Adds github settings integration with Mdoc. See the documentation
    for details.
	
* [sbt-mdoc][sbtMdoc]
    
* [sbt-scalfmt][sbtScalaFmt]

    Adds scalafmt capabilities to update and check for proper
    formatting of the project in ci workflows and in the sbt console.

[g8]: https://www.foundweekends.org/giter8/
[sbtCiRelease]: https://github.com/sbt/sbt-ci-release
[sbtGithubActions]: https://github.com/sbt/sbt-github-actions
[sbtDependencyUpdates]: https://github.com/aiyanbo/sbt-dependency-updates
[sbtHeader]: https://github.com/sbt/sbt-header
[sbtGithub]: https://github.com/er1c/sbt-github
[sbtGithubMdoc]: https://alejandrohdezma.github.io/sbt-github/docs/integrations/sbt-mdoc/
[sbtMdoc]: https://github.com/m-doc/sbt-mdoc
[sbtScalaFmt]: https://github.com/scalameta/sbt-scalafmt

