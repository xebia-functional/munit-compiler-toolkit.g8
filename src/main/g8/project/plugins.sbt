import Dependencies.SbtPlugins._

resolvers += Resolver.sonatypeRepo("public")

addSbtPlugin(sbtMunitCompilerToolkit)
addSbtPlugin(sbtCiRelease)
addSbtPlugin(sbtGithubActions)
addSbtPlugin(sbtHeader)
addSbtPlugin(sbtDependencyUpdates)
addSbtPlugin(sbtMdoc)
addSbtPlugin(sbtGithub)
addSbtPlugin(sbtGithubMdoc)
addSbtPlugin(sbtScalafmt)
