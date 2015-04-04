/*
  Composition and Inheritance.
  Note:  Methods with no parameters and no side effects should be called without parentheses.
 */
object Ten {

  abstract class Cheese {
    /*
      This can contain methods without implementations.
      Any instantiation of an abstract class will result in a compiler
      error.
     */
    def weight: Double
    def breads: Array[String]
    def bitches(): Unit = {
      println("Bitches")
    }
    def smell: String
    def age: Int
  }

  abstract class Cheddar extends Cheese {
    def sharp: Boolean
  }

  /*
      This is an implementation 2 nodes away from our root abstract class cheese.
     */
  class WholeFoodsCheddar() extends Cheddar {

    def sharp = true

    def weight = 10.5

    def age = 2

    def breads = Array("Wheat", "Sourdough", "Pita")

    def smell = "Stinky"
  }

  



  def main(args: Array[String]): Unit = {
    val cheese = new WholeFoodsCheddar
    for (i <- 0 to 100) cheese.bitches()
  }
}
