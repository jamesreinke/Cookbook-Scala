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
    // we can choose to type cast the argument x or not
    args.foreach((x: String) => println(x))
    args.foreach(println)
  }


}