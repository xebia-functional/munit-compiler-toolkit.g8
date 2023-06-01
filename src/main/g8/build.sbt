import Dependencies.Compile._

ThisBuild / scalaVersion := "$scalaVersion$"
ThisBuild / organization := "$organization$"
ThisBuild / versionScheme := Some("early-semver")
ThisBuild / homepage := Some(
  url("$projectHomepage$")
)
ThisBuild / licenses := List(
  $licenseKey$ -> new URL(
    $licenseURL$
  )
)
ThisBuild / developers := List(
  Developer(
    "$authorName;format="lower,hyphen"$",
    "$authorName$",
    "$authorEmail$",
    url("$authorWebsite$")
  )
)

//YOU MAY REMOVE THIS IF YOU HAVE THE PROJECT IN A LOCAL GIT CHECKOUT OF A REMOTE REPOSITORY
ThisBuild / scmInfo := Some(
  ScmInfo(
    url(
      "https://github.com/$organizationName;format="lower,hyphen"$/$name;format="lower,hyphen"$"
    ),
    "scm:git:https://github.com/$organizationName;format="lower,hyphen"$/$name;format="lower,hyphen"$.git"
  )
)
//END-YOU MAY REMOVE THIS IF YOU HAVE THE PROJECT IN A LOCAL GIT CHECKOUT OF A REMOTE REPOSITORY
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / githubWorkflowTargetTags ++= Seq("v*")
ThisBuild / githubWorkflowPublishTargetBranches :=
  Seq(RefPredicate.StartsWith(Ref.Tag("v")))
ThisBuild / githubWorkflowPublish := Seq(
  WorkflowStep.Sbt(
    List("ci-release"),
    env = Map(
      "PGP_PASSPHRASE" -> "\${{ secrets.PGP_PASSPHRASE }}",
      "PGP_SECRET" -> "\${{ secrets.PGP_SECRET }}",
      "SONATYPE_PASSWORD" -> "\${{ secrets.SONATYPE_PASSWORD }}",
      "SONATYPE_USERNAME" -> "\${{ secrets.SONATYPE_USERNAME }}"
    )
  )
)
addCommandAlias(
  "ci-test",
  "scalafmtCheckAll; scalafmtSbtCheck; github; documentation / mdoc; root / Test / test"
)
addCommandAlias("ci-it-test", "$projectBaseName$-plugin / IntegrationTest / test")
addCommandAlias("ci-docs", "github; documentation / mdoc")
addCommandAlias("ci-publish", "github; ci-release")

lazy val commonSettings = Seq(
  organizationName := "$organizationName$",
  startYear := Some(2023)
)

lazy val root = project
  .in(file("."))
  .settings(commonSettings)
  .settings(
    name := "$projectBaseName$-root",
    publish / skip := true,
  )
  .aggregate(`$projectBaseName$-lib`, `$projectBaseName$-plugin`, `$projectBaseName$-examples`, `documentation`)

lazy val `$projectBaseName$-lib` = project
  .in(file("./$projectBaseName$-lib"))
  .settings(autoAPIMappings := true)
  .settings(commonSettings)

lazy val `$projectBaseName$-plugin` = project
  .in(file("./$projectBaseName$-plugin"))
  .settings(commonSettings)
  .dependsOn(`$projectBaseName$-lib`)
  .enablePlugins(SbtMunitCompilerToolkitPlugin)

lazy val `$projectBaseName$-examples` = project
  .in(file("./$projectBaseName$-examples"))
  .dependsOn(`$projectBaseName$-lib`, `$projectBaseName$-plugin`)
  .settings(
    publish / skip := true,
    autoCompilerPlugins := true,
    Compile / fork := true,
    Compile / scalacOptions += s"""-Xplugin:\${(`$projectBaseName$-plugin` / Compile / packageBin).value}""",
    Compile / scalacOptions += s"""-Xprint:$name;format="lower,hyphen"$phase""",
  )

lazy val documentation = project
  .dependsOn(`$projectBaseName$-lib`, `$projectBaseName$-plugin`)
  .settings(commonSettings)
  .enablePlugins(MdocPlugin)
  .settings(mdocOut := file("."))
  .settings(publish / skip := true)
