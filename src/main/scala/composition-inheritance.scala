/*
  Composition and Inheritance.
  Note:  Methods with no parameters and no side effects should be called without parentheses.
 */
object CompInher {

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


  /*
    An example of how certain elements are dynamically bound.
   */
  abstract class Ele {
    def demo(): Unit = {
      println("Element's implementation invoked")
    }
  }
  class ArrayEle extends Ele {
    override def demo(): Unit = {
      println("ArrayElement's implementation invoked")
    }
  }
  final class LineEle extends ArrayEle { // prevent inheritence
    override def demo(): Unit = { // prevent overiding with final; redundant if class is final
      println("LineELement's implementation invoked")
    }
  }
  class UniformEle extends Ele
  def invokeDemo(e: Ele): Unit = {
    e.demo()
  }

  /*
    A final example.
   */
  import Element.elem
  abstract class Element {
    def contents: Array[String]

    def width: Int = contents(0).length
    def height: Int = contents.length

    def above(that: Element): Element = {
      val this1 = this widen that.width
      val that1 = that widen this.width
      elem(this1.contents ++ that1.contents)
    }
    def beside(that: Element): Element = {
      val this1 = this heighten that.height
      val that1 = that heighten this.height
      elem(
        for ((line1, line2) <- this1.contents zip that1.contents)
          yield line1 + line2
      )
    }
    def widen(w: Int): Element =
      if (w <= width) this
      else {
        val left = elem(' ', (w - width) / 2, height)
        val right = elem(' ', w - width - left.width, height)
        left beside this beside right
      }
    def heighten(h: Int): Element =
      if (h <= height) this
      else {
        val top = elem(' ', width, (h - height) / 2)
        var bot = elem(' ', width, h - height - top.height)
        top above this above bot
      }
    override def toString = contents mkString "\n"
  }
    /*
      Factory object with factory methods.
     */
  object Element {
    private class ArrayElement(
      val contents: Array[String]
    ) extends Element
    private class LineElement(s: String) extends Element {
      val contents = Array(s)
      override def width = s.length
      override def height = 1
    }
    private class UniformElement(
      ch: Char,
      override val width: Int,
      override val height: Int
      ) extends Element {
        private val line = ch.toString * width
        def contents = Array.fill(height)(line)
    }
    def elem(contents: Array[String]): Element =
      new ArrayElement(contents)
    def elem(chr: Char, width: Int, height: Int): Element =
      new UniformElement(chr, width, height)
    def elem(line: String): Element =
      new LineElement(line)
  }
  /*
    The spiral example.
   */
  object Spiral {
    val space = elem(" ")
    val corner = elem("+")
    def spiral(nEdges: Int, direction: Int): Element = {
      if (nEdges == 1)
        elem("+")
      else {
        val sp = spiral(nEdges - 1, (direction + 3) % 4)
        def verticalBar = elem('|', 1, sp.height)
        def horizontalBar = elem('-', sp.width, 1)
        if (direction == 0)
          (corner beside horizontalBar) above (sp beside space)
        else if (direction == 1)
          (sp above space) beside (corner above verticalBar)
        else if (direction == 2)
          (space beside sp) above (horizontalBar beside corner)
        else
          (verticalBar above corner) beside (space above sp)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    println(Spiral.spiral(args(0).toInt, 0))
  }

}
