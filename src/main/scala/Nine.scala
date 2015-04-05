

/*
  Control abstraction
 */
object Nine {

  /*
    Reducing code duplication.  An example with the matcher function.
   */
  object FileMatcher {
    private def filesHere = new java.io.File(".").listFiles()
    private def filesMatching(matcher: String => Boolean) =
      for (file <- filesHere; if matcher(file.getName))
        yield file
    def filesEnding(query: String) =
      filesMatching(_ endsWith query)
    def filesContaing(query: String) =
      filesMatching(_ contains query)
    def filesRegex(query: String) =
      filesMatching(_ matches query)
  }

  /*
    Simplifying client code.
   */
  def containsNeg(nums: List[Int]) = nums.exists(_ < 0) // built from the scala library and not into the scala language

  /*
    Currying
   */
  def painOldSum(x: Int, y: Int) = x + y
  def curriedSum(x: Int)(y: Int) = x + y
  def curriedSumEquiv(x: Int) = (y: Int) => x + y // applies the scope in order of paremeters; lambda calculus!
  val first = curriedSumEquiv(1) // _ represents the rest of the arguments
  val second = first(2) // = 3
  val onePlus = curriedSum(1)_
  val twoPlus = onePlus(2) // = 3

  /*
    Writing new control structures
   */
  def twice(op: Double => Double, x: Double) = op(op(x))
  twice( _ + 1, 5) // = 7.0

  /*
    By name parameters.
   */
  var assertionsEnabled = true
  def myAssert(predicate: () => Boolean) =
    if (assertionsEnabled && !predicate())
      throw new AssertionError
  def byNameAsser(predicate: => Boolean) =
    if (assertionsEnabled && !predicate)
      throw new AssertionError




  def main(args: Array[String]): Unit = {

  }
}
