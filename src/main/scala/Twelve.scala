/*
Traits
*/

object Twelve {
	trait Philosophical {
		def philosophize() {
			println("I consume memory, therefor I am!")
		}
	}
	class Animal{}
	trait HasLegs{}
	class Frog extends Animal with Philosophical with HasLegs{
		override def toString = "green"
	}
	new Frog().philosophize()
}