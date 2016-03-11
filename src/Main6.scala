import scala.util.Try

/**
  * Created by doiken on 2016/03/10.
  */
object Main6 {
  def main(args: Array[String]) {
    val account = args(0)
    val budget = Try(args(1).toInt).toOption
      .filter(_ > 0)
      .map(_ - 100)
    val days = Try(args(2).toInt).toOption
      .filter(_ < 30)
      .map(_ * 7)

    val message = for {
      b  <- budget.toRight("お金が...＼(^o^)／").right
      d  <- days.toRight("4週以内で指定して下さい").right
      db <- dailyBudget(b, d).toRight("日予算が１円を切りました").right
    } yield s"${account}さんの日割り予算は${db}円です"

    message match {
      case Right(b) =>
        println(b)
      case Left(b) =>
        println(b)
        sys.exit(2)
    }
  }

  private def dailyBudget(budget: Int, days: Int): Option[Int] = {
    Try(budget / days).toOption
      .filter(i => i > 0)
  }
}
