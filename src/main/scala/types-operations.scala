/*
  Basic Types and Operations
 */

object TypesOps {


  /*
    Bits, Bytes and other Cheese

  Byte // 8-bit signed two's complement integer
  Short // 16-bit signed two's complement integer
  Int // 32-bit signed two's complement integer
  Long // 64-bit signed two's complement integer
  Char // 16-bit unsigned Unicode character
  String // Sequence of Char's
  Float // 32-bit IEEE 754 single-precision float
  Double // 64-bit IEEE 754 double-precision float
  Boolean // true or false
  */


  /*
    Types usage example.
   */
  def main(args: Array[String]): Unit = {

    // hexadecimal base 16: 0x...
    val hex = 0x5
    val hex2 = 0x00FF
    val magic = 0xcafebabe

    // to create a long integer...
    val tower = 35L
    val prog = 0xFL

    // byte my shorts
    val little: Short = 238
    val littler: Byte = 38

    /*
      Float versus dubs.
     */
    val dubs = 1.567
    val floats = 1.567F
    val dubDubs = 3e7 // exponentiation; byyyyaaaa

    println("""I can "write" whatever I want '\s' and not worry about anything "weird" happening.""")
    println("""It's like adding another quote god.  I hope sober you understands the reference""")


    // operators
    val sum = 1 + 2
    val s = "Hello World!"
    s indexOf 'o'
    s indexOf ('o', 5) // index of 'o' starting at position 5

    // if method has side effects, include () at the end
    11 / 4 // 2
    11 % 4 // 3
    // remainder can be different
    math.IEEEremainder(11.0, 4.0)
    val iAmBored = !true

    // example of short circuiting
    def salt() = { println("salt"); false}
    def pepper() = { println("pepper"); true}
    pepper & salt
    salt & pepper // only prints "salt"


    /*
      Bitwise operations
     */
    1 & 2 // bitwise-and => 0: Int
    1 | 2 //  bitwise-or => 3: Int
    1 ^ 3 // bitwise-xor => 2: Int
    ~1    // complement => -2: Int
    -1 >> 31  // right shift
    -1 >>> 31 // unsigned right shift
    1 << 2    // left shift
    2 << 2 + 2 // => 32: Int
    2 + 2 << 2 // => 16: Int






  }

}
