/*
  The Basics Part 1
 */
object Two {



  def main(args: Array[String]) = {
    /*
      Loops and poops.
     */
    var i = 0
    while(i < args.length){
      println(args(i))
      i += 1
    }
    args.foreach((x: String) => println(x))
    args.foreach(println)
  }


}