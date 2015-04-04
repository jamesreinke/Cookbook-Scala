

/*
  Functions and Closures
 */
object Eight {

  /*
    Prints all of the lines that exceed the margin, prefixed with the filename.
   */
  import scala.io.Source
  object LongLines {
    def procesFile(filename: String,
                   width: Int): Unit = {
      val source = Source.fromFile(filename)
      for (line <- source.getLines())
        processLine(filename, width, line)
    }
    private def processLine(filename: String,
                             width: Int,
                             line: String): Unit = {
      if (line.length > width)
        println(filename +": " + line.trim)
    }
  }
  /*
    A different approach with a nested function.  Makes more sense if process line will not be used in
    the rest of the object.  We can use the outer-scope parameters!
   */
  def processFileTwo(filename: String,
                      width: Int): Unit = {
    def processLine(line: String): Unit = {
      if (line.length > width)
         println(filename + ": " + line.trim)
    }
    val source = Source.fromFile(filename)
    for (line <- source.getLines()) {
      processLine(filename)
    }
  }

  /*
    First class functions.
   */
  // an example of a function literal
  val increase = (x: Int) => {
    println("Your one integer will arrive shortly...")
    for(i <- 0 to 4) {
      println((5-i) +" seconds remaining")
      sys.wait(1000)
    }
    x + 1
  }
  increase(10)

  /*
    Passing function literals to some known collection methods.
   */
  val alphabet = List("a", "b", "c", "d", "go fuck yourself")
  alphabet.filter((x: String) => x matches "[a-z]*")

  /*
    Placeholer syntax
   */
  alphabet.filter(_ matches "[a-z]*")
  val f = (_: Int) + (_: Int)

  /*
    Partially applied functions
   */
  def sum(a: Int, b: Int, c: Int) = a + b + c
  val a = sum _ // a(1,1,1) == a.apply(1,1,1)
  val b = sum(1, _: Int, 3) // b(-1) == a(1,1,1)

  /*
    Closures
      Every time a function is called, a new closure is created, capturing the values of unbound variables.
   */
  val more = 5
  (x: Int) => x + 1 // closed term
  (x: Int) => x + more // open term; we generate a closure when the function is called

  /*
    Special function call forms: Why not always use arrays or lists?
   */
  def echo(args: String*) = // * allows for any number of args to be passed
    for(arg <- args) println(arg)
  val arr = Array("Bird", "is", "the", "word.")
  echo(arr: _*) // tells the compiler to pass each element of the Array as its own string argument

  /*
    Named arguments
   */
  def speed(distance: Float, time: Float): Float = {
    distance / time
  }
  speed(100, 10)
  speed(time = 10, distance = 100)  // named arguments allow reordering

  /*
    Default parameter values
   */
  def printTime(out: java.io.PrintStream = Console.out,
                 divisor: Int = 1) =
    out.println("time = " + System.currentTimeMillis()/1)
  printTime(divisor = 100)
  printTime(Console.err)

  /*
    Tail recursion.
   */
  def boom(x: Int): Int =
    if (x == 0) throw new Exception("bang!") // exception stack trace will only be one frame for boom no matter what value for x
    else boom(x - 1)
    /*
      In these examples the compiler will not optimize for tail recursion.
     */
  def isEven(x: Int): Boolean =
    if (x == 0) true else isOdd(x - 1)
  def isOdd(x: Int): Boolean =
    if (x == 0) false else isEven(x - 1)

  val funValue = nestedFun _
  def nestedFun(x: Int): Unit = {
    if (x != 0) { println(x); funValue(x - 1)}
  }












  def main(args: Array[String]): Unit = {

  }
}
