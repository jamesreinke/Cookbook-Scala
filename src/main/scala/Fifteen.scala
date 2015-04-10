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
	/*
	Case classes automatically add factory methods.
	*/
	val v = Var("x") // no 'new' required
	v.name // all parameters are automatically instantiated with a var
	val op = BinOp("+", Number(1), v)
	op.left
	op.right == Var("x") // should return true
	var opCopy = op.copy(operator = "-") // automatic implementation of the copy method
}