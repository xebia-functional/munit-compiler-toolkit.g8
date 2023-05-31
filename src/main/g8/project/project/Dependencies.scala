import sbt._
object Dependencies {

  object Versions {
    val sbtMunitCompilerToolkit = $munitCompilerToolkitVersion$
    val sbtCiRelease = $sbtCiReleaseVersion$
    val sbtGithubActions = $sbtGithubActionsVersion$
    val sbtDependencyUpdates = $sbtDependencyUpdatesVersion$
    val sbtHeader = $sbtHeaderVersion$
    val sbtGithub = $sbtGithubVersion$
    val sbtGithubMdoc = $sbtGithubVersion$
    val sbtMdoc = $sbtMdocVersion$
    val sbtScalafmt = $sbtScalafmtVersion$
    val munit = $munitVersion$
  }

  object Compile {
    
  }

  object SbtPlugins {
    val sbtCiRelease = "com.geirsson" % "sbt-ci-release" % Versions.sbtCiRelease
    val sbtGithubActions =
      "com.codecommit" % "sbt-github-actions" % Versions.sbtGithubActions
    val sbtDependencyUpdates =
      "org.jmotor.sbt" % "sbt-dependency-updates" % Versions.sbtDependencyUpdates
    val sbtHeader = "de.heikoseeberger" % "sbt-header" % Versions.sbtHeader
    val sbtGithub = "com.alejandrohdezma" %% "sbt-github" % Versions.sbtGithub
    val sbtGithubMdoc =
      "com.alejandrohdezma" % "sbt-github-mdoc" % Versions.sbtGithubMdoc
    val sbtMdoc = "org.scalameta" % "sbt-mdoc" % Versions.sbtMdoc
    val sbtScalafmt = "org.scalameta" % "sbt-scalafmt" % Versions.sbtScalafmt
    val sbtMunitCompilerToolkit = "com.xebia" % "sbt-munit-compiler-toolkit" % Versions.sbtMunitCompilerToolkit
  }

  object Test {
  }

  lazy val dependencies =
    Seq(
      SbtPlugins.sbtCiRelease,
      SbtPlugins.sbtGithubActions,
      SbtPlugins.sbtDependencyUpdates,
      SbtPlugins.sbtHeader,
      SbtPlugins.sbtGithub,
      SbtPlugins.sbtGithubMdoc,
      SbtPlugins.sbtMdoc,
      SbtPlugins.sbtScalafmt,
    )

}
