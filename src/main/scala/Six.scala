/*
  Functional Objects
 */
object Six {


  /*
    A functional class representing rational numbers.
   */
  class Rational(n: Int, d: Int) {
    require (d != 0) // pre-condition
    val numerator: Int = n
    val denominator: Int = d
    // auxiliary constructor
    def this(n: Int) = this(n, 1)
    override def toString = numerator + "/" + denominator


    /*
      We can define custom operators using the following operator syntax.
      This also enforces the compiler to respect operator precedence.
     */
    def + (i: Int): Rational =
      new Rational(numerator + i * denominator, denominator)
    def + (that: Rational): Rational =
      new Rational(
        numerator * that.denominator + that.numerator * denominator,
        denominator * that.denominator
      )
    def - (i: Int): Rational =
      new Rational(numerator - i * denominator, denominator)
    def - (that: Rational): Rational =
      new Rational(
        numerator * that.denominator - that.numerator * denominator,
        denominator * that.denominator
      )
    def * (i: Int): Rational =
      new Rational(numerator * i, denominator)
    def * (that: Rational): Rational =
      new Rational(numerator * that.numerator, denominator * that.denominator)
    def / (i: Int): Rational =
      new Rational(numerator, denominator * i)
    def / (that: Rational): Rational =
      new Rational(numerator * that.denominator, that.numerator * denominator)
    // with these operator, it is the case that a rational has to be on the left-hand side
    implicit def intToRationl(x: Int) = new Rational(x)
    // now rational can appear on the right hand side of an integer statement

    /*
      Recursive solution to greatest common divisor.
     */
    private def gcd(a: Int, b: Int): Int =
      if (b == 0) a else gcd(b, a % b)


  }


  def main(args: Array[String]): Unit ={

  }
}
