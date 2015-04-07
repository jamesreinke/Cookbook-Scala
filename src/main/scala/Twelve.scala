/*
Traits
*/

object Twelve {

	/*
	A first example.
	*/
	trait Philosophical {
		def philosophize() {
			println("I consume memory, therefor I am!")
		}
	}
	class Animal{}
	trait HasLegs{}
	class Frog extends Animal with Philosophical with HasLegs {
		override def toString = "green"
	}
	new Frog().philosophize()
	
	trait CharSequence {
		def charAt(index: Int): Char
		def length: Int
		def subSequence(start: Int, end: Int): CharSequence
		def toString(): String
	}

	/*
	An example with graphics.
	*/
	class Point(first: Int, second: Int) {
		val x = first
		val y = second
	}
	trait Rectangular {
		def topLeft: Point
		def bottomRight: Point

		def left = topLeft.x
		def right = bottomRight.x
		def width = right - left
	}
	
	/*
	The Ordered Trait
	*/
	class Rational(n: Int, d: Int) extends Ordered[Rational] {
		val numer = n
		val denom = d
		def compare(that: Rational) = 
			(this.numer * that.denom) - (that.numer * this.denom)
	}

	/*
	Traits as Stackable Modifications
	*/
	abstract class IntQueue {
		def get(): Int
		def put(x: Int)
	}
	import scala.collection.mutable.ArrayBuffer

	class BasicIntQueue extends IntQueue {
		private val buf = new ArrayBuffer[Int]
		def get() = buf.remove(0)
		def put(x: Int) { buf += x }
	}

	trait Doubling extends IntQueue {
		abstract override def put(x: Int) { super.put(2 * x) }
	}

	trait Incrementing extends IntQueue {
		abstract override def put(x: Int) { super.put(x + 1) }
	}

	trait Filtering extends IntQueue {
		abstract override def put(x: Int) {
			if (x >= 0) super.put(x)
		}
	}
	
	def main(args: Array[String]): Unit = {
		/* 
		With this order, there should be no exception. 
		Increment is applied first.
		*/
		val queue = (new BasicIntQueue with Filtering with Incrementing)
		queue.put(-1)
		queue.put(-1)
		println(queue.get())

	}


	
}