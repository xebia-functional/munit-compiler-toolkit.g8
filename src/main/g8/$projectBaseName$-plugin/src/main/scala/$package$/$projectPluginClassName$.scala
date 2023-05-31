package $package$

import dotty.tools.dotc.ast.tpd.*
import dotty.tools.dotc.core.Constants.Constant
import dotty.tools.dotc.core.Contexts.Context
import dotty.tools.dotc.core.Names
import dotty.tools.dotc.core.StdNames
import dotty.tools.dotc.core.Symbols.*
import dotty.tools.dotc.plugins.PluginPhase
import dotty.tools.dotc.plugins.StandardPlugin
import dotty.tools.dotc.transform.Staging

class $projectPluginClassName$ extends StandardPlugin:
  val name: String = "$projectPluginClassName$"
  override val description: String = "$name"
  override def init(options: List[String]): List[PluginPhase] =
    $projectPluginClassName$Phase() :: Nil
end $projectPluginClassName$

class $projectPluginClassName$Phase() extends PluginPhase:
  override def phaseName: String = $projectPluginClassName$Phase.name
  override val runsAfter = Set("$compilerPhaseAfterPluginPhase$")
  override def runsBefore: Set[String] = Set("$compilerPhaseBeforePluginPhase$")
  private def extractNestedArgs(
      tree: Tree,
      args: List[List[Tree]]
  ): List[List[Tree]] =
    tree match {
      case Apply(b @ Apply(fn, _), largs) =>
        extractNestedArgs(b, args.appended(largs))
      case Apply(b @ TypeApply(fn, _), largs) =>
        extractNestedArgs(b, args.appended(largs))
      case Apply(fn, largs) => args.appended(largs)
      case _                => args
    }

  private lazy val loggingInterceptorName = "$package$.LoggingInterceptor"
  override def transformApply(tree: Apply)(using Context): Tree =
    val loggingInterceptor = requiredClassRef(
      loggingInterceptorName
    )
    val __apply__ = Names.termName("apply")
    if (
      tree.fun.symbol.name.show == StdNames.nme.CONSTRUCTOR.show && tree.fun.symbol.name.show != "<none>" && !tree.fun.symbol.annotations
        .exists(_.symbol.name.show != "main")
    ) tree
    else
      val extractedArgs = extractNestedArgs(tree, Nil).filterNot(_.isEmpty)
      val argsToLog = (List(
        Literal(Constant(tree.fun.symbol.showFullName))
      ) :: extractedArgs).flatten
      if (extractedArgs.isEmpty)
        New(
          loggingInterceptor
        ).select(StdNames.nme.CONSTRUCTOR)
          .appliedToType(tree.fun.symbol.info.finalResultType)
          .appliedTo(tree)
          .select(__apply__, _.paramSymss.flatten.size == 1)
          .appliedToArgs(argsToLog)
      else
        New(
          loggingInterceptor
        ).select(StdNames.nme.CONSTRUCTOR)
          .appliedToType(tree.fun.symbol.info.finalResultType)
          .appliedTo(tree)
          .select(__apply__, _.paramSymss.flatten.size > 1)
          .appliedToArgs(
            List(
              Literal(Constant(tree.fun.symbol.showFullName))
            )
          )
          .appliedToVarargs(
            extractedArgs.flatten,
            TypeTree(summon[Context].definitions.AnyType)
          )
end $projectPluginClassName$Phase

object $projectPluginClassName$Phase:
  val name = "$name;format="lower,hyphen"$phase"
end $projectPluginClassName$Phase



