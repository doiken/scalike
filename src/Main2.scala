/**
  * Created by doiken on 2016/03/10.
  */
object Main2 {
  def main(args: Array[String]) {
    val account = args(0)

    val budget = Some(args(1).toInt)
      .filter(b => b > 0)
      .map(b => b - 100)

    budget match {
      case Some(b) =>
        println(account + "さんの予算は" + b + "円です")
      case None =>
        println("お金が...＼(^o^)／")
        sys.exit(1)
    }

    val message = budget
      .map(b => account + "さんの予算は" + b + "円です")
      .getOrElse("お金が...＼(^o^)／")
    println(message)
  }
}
