/*
  The Basics Part 2
 */

object BasicsTwo {


  def main(args: Array[String]) = {

    /*
      Initializing objects and for for whores.
     */
    for (i <- 0 to 100){
      print(i + " ")
    }
    val numbersArray = Array("zero", "one", "two") // all types are objects with methods, including things like an array
    val lettersArray = Array.apply(("a", "b", "c")) // this array initialization is equivalent to the one above


    /*
      Lists full of Women
     */
    val thizz = "Jall " :: "thizz" :: "me?" :: Nil
    val numbersList = List("one", "two", "three") ::: List("four", "five", "six")
    numbersList(2) // O(n)
    numbersList.exists(x => x == "one") // checks to see if one exists in the list: O(n)
    numbersList.count(x => x.length == 2) // counts the number of length 2 words
    numbersList.forall(x => x.length > 1) // returns true if there are no empty strings in the list
    numbersList.foreach(x => println(x))  // performs any arbitrary action
    thizz.head
    thizz.tail
    thizz.last // O(n)
    thizz.reverse
    thizz.isEmpty
    numbersList.sortBy(x => x) // sorts the list given some rule

    /*
      A more functional style...
     */

    def formatArgs(args: Array[String]) = args.mkString("\n")
    println(formatArgs(args))

    /*
      A taste of the scrumptious I/O
      Padding formatted character counts for the contents of a file.
     */
    import scala.io.Source
    def widthOfLength(s: String) = s.length.toString.length
    if (args.length > 0) {
      val lines = Source.fromFile(args(0)).getLines().toList
      // reduce left action
      val longestLine = lines.reduceLeft(
        (a,b) => if(a.length > b.length) a else b
      )
      val maxWidth = widthOfLength(longestLine)

      for(line <- lines) {
        val numSpaces = maxWidth - widthOfLength(line)
        val padding = " " * numSpaces
        println(padding + line.length + " | " + line)
      }
    }
    else
      Console.err.println("Please enter a filename")
  }




}