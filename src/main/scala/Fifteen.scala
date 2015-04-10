/*
Case classes and Pattern Matching
*/
object Fifteen {
	/*
	A Simple Example
	*/
	abstract class Expr
	case class Var(name: String) extends Expr
	case class Number(num: Double) extends Expr
	case class UnOp(
		operator: String, 
		arg: Expr) extends Expr
	case class BinOp(
		operator: String,
		left: Expr, 
		right: Expr) extends Expr
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
	expr match {
		// three element list starting with 0
		case List(0, _, _) => println("found it!")
		case _ => println("not found")
	}


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
}