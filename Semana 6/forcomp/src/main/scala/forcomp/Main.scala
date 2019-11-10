package forcomp
import Anagrams._

object Main extends App {
  def aux(w: String): List[(Char, Int)] = {
    w.toLowerCase.groupBy(x => x).mapValues(y => y.length).toList.sorted
  }

  println(dictionaryByOccurrences(wordOccurrences("eat")))
}
