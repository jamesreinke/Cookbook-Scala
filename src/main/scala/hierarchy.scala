/*
	Scala's Hierarchy
*/
object Hierarchy {
	/*
		These should output the same for objects and primitives.
	*/
	def isEqual(x: Int, y: Int) = x == y
	def isEqual(x: Any, y: Any) = x == y
	
	def divide(x: Int, y: Int): Int = {
		if (y != 0) x / y //: Int
		else error("Can't divide by zero.") //: Nothing
	}
	
	
	
}