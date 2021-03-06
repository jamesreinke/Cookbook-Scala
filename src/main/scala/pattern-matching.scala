/*
Case classes and Pattern Matching
*/
object PatMatch {
	/*
	A Simple Example
	The sealed prefix ensures that matched cases are exhaustive.
	*/
	sealed abstract class Expr
	case class Var(name: String) extends Expr
	case class Number(num: Double) extends Expr
	case class UnOp(
		operator: String, 
		arg: Expr) extends Expr
	case class BinOp(
		operator: String,
		left: Expr, 
		right: Expr) extends Expr

	/*
	Case classes automatically add factory methods.
	*/
	val v = Var("x") // no 'new' required
	println(v.name) // all parameters are automatically instantiated with a var
	val op = BinOp("+", Number(1), v)
	println(op.left)
	println(op.right == Var("x")) // should return true
	var opCopy = op.copy(operator = "-") // automatic implementation of the copy method
	println("")

	/*
	Ways to match!
	*/
	def simplifyTop(expr: Expr): Expr = expr match {
		case UnOp("-", UnOp("-", e)) => e
		case BinOp("+", e, Number(0)) => e
		case BinOp("*", e, Number(1)) => e
		case _ => expr
	}
	def describe(x: Any): String = x match {
		case 5 => "five"
		case true => "truth"
		case "hello" => "hi!"
		case Nil => "Nil"
		// we could also use _ for the wildcard
		case somethingElse => "no pattern matched for object " + somethingElse
	}

	/*
	deep case match
	*/
	val expr: Any = Nil
	expr match {
		// three element list starting with 0
		case List(0, _, _) => println("found it!")
		// matches any length list with starting element 0
		case List(0, _*) => println("kind of found it")
		case _ => println("not found")
	}

	/*
	this does not work; scala, like java uses the erasure model of generics
	we can only match Map[Any, Any]
	*/
	def isIntIntMap(x: Any): Boolean = x match {
		case m: Map[Int, Int] => true
		case _ => false
	}

	/*
	Variable Binding
	*/
	expr match {
		// pattern matching while making a variable available 
		case UnOp("abs", e @ UnOp("abs", _)) => e
		case _ => expr
	}

	/*
	Pattern Guards
	*/
	def simplifyAdd(e: Expr) = e match {
		case BinOp("+", x, y) if x == y =>
			BinOp("*", x, Number(2))
		case _ => e
	}

	/*
	Pattern Overlaps
	*/
	def simplifyAll(expr: Expr): Expr = expr match {
		case UnOp("-", UnOp("-", e)) =>
			simplifyAll(e)
		case BinOp("+", e, Number(0)) =>
			simplifyAll(e)
		case binOp("*", e, Number(1)) =>
			simplifyAll(e)
		case UnOp(op, e) =>
			UnOp(op, simplifyAll(e))
		case BinOp(op, l, r) =>
			BinOp(op, simplifyAll(l), simplifyAll(r))
		case _ => expr
	}

	/*
	Since our class is sealed, we need an exhaustive match.
	@unchecked removes this requirement
	*/
	def describe(e: Expr): String = (e: @unchecked) match {
		case Number(_) 	=> "a number"
		case Var(_) 	=> "a variable"
	}

	/*
	The Option Type
	*/
	def show(x: Option[String]) = x match {
		case Some(s) => s
		case None => "?"
	}	
	var capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
	show(capital get "France")

	/*
	Patterns Everywhere
	*/
	val myTuple = (123, "abc")
	val (number, string) = myTuple
	

}