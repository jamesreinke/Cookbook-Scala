/*
  Built-in Control Structures
 */
object Seven {


  /*
    All hail to the functional style.  Creates a multiplication table.
    Notice the useful yield syntax!
   */
    /*
      Returns a row as a sequence
      */
  def makeRowSeq(row: Int) =
    for(col <- 1 to 10) yield {
      val prod = (row * col).toString
      val padding = " " * (4 - prod.length)
      padding + prod
    }

  def makeRow(row: Int) = makeRowSeq(row).mkString // Returns a row as a string
    /*
      Returns table as a string with one row per line
      */
  def multiTable() = {

    val tableSeq = for (row <- 1 to 10) yield makeRow(row)
    tableSeq.mkString("\n")
  }

  def main(args: Array[String]): Unit = {

    /*
      A Little iteration with file I/O.
     */
    var line = ""
    do {
      line = readLine()
      println("Read: " + line)
    } while (line != "")
    val filesHere = new java.io.File(".").listFiles()
    for( file <- filesHere)
      println(file)

    /*
     yields an Array of files
      */
    def scalaFiles =
      for {
        file <- filesHere
        if file.getName.endsWith(".scala")
      } yield file

    /*
      Throwing and catching exceptions!
     */
    val half =
      if (n % 2 == 0)
          n / 2
      else
        throw new RuntimeException("n must be even")
    import java.io._
    try {
      val f = new FileReader("input.txt")
    } catch {
      case ex: FileNotFoundException => println("No file Bro.")
      case ex: IOException => println("Some other IO whatevers.")
    }
    val file = new FileReader("inputs.txt")
    try {
      /*
        Do anything what we want with the file here.
       */
    } finally {
      file.close() // close the file with or without an exception
    }
    /*
      match expression
      */
    for(i <- 0 to 100) i % 10 match {
      case 0 => println(i)
    }
  }
}
