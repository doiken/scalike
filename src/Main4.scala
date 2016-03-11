/**
  * Created by doiken on 2016/03/10.
  */
object Main4 {
  def main(args: Array[String]) {
    val account = args(0)
    val budget = Some(args(1).toInt)
      .filter(b => b > 0)
      .map(b => b - 100)
    val days = Some(args(2).toInt)
      .filter(w => w < 30)
      .map(w => w * 7)

    val message = for {
      b <- budget.toRight("お金が...＼(^o^)／").right
      d <- days.toRight("4週以内で指定して下さい").right
    } yield s"${account}さんの予算は${b}円(${d}日)です"

    message match {
      case Right(b) =>
        println(b)
      case Left(b) =>
        println(b)
        sys.exit(2)
    }
  }
}
