/**
  * Created by doiken on 2016/03/10.
  */
object Main {
  def main(args: Array[String]) {
    var account = args(0)
    var budget = args(1).toInt

    if (budget <= 0) {
      println("お金が...＼(^o^)／")
      sys.exit(1)
    }

    budget = budget - 100
    budget

    println(account + "さんの予算は" + budget + "円です")
  }

}
