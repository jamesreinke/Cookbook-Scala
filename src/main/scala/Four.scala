

/**
 * Classes and objects.
 */
object Four {


  class TheCheeze {
    /*
      Cheese and the structure of a definition.
     */
    private var cheese = 0
    def add(b: Byte): Unit = cheese += b
    def checksum(): Int = ~(cheese & 0xFF) + 1
    // different ways to write return types
    def g() {"This is bullshit"} // returns Unit(), not the string
    def h() = {"This isn't bullshit"}

    // semi colons
    val s = "hello"; println(s)
  }

  /*
    First look at a functional class.  We can create objects for API calls or we can instantiate a class.
   */
  class ChecksumAccumulator {
    import scala.collection.mutable.Map
    private val cache = Map[String, Int]()

    private var sum = 0 // we don't want outsiders touching our cheese

    def add(b: Byte): Unit = sum += b
    def checksum(): Int = ~(sum & 0xFF) + 1

    def calculate(s: String): Int =
      if (cache.contains(s))
        cache(s)
      else {
        val acc = new ChecksumAccumulator
        for (c <- s)
          acc.add(c.toByte)
        val cs = acc.checksum()
        cache += (s -> cs)
        cs
      }
  }


  def main(args: Array[String]) = {
      for (arg <- args)
        println(arg + ":  " + (new ChecksumAccumulator).calculate(arg))
  }





}
