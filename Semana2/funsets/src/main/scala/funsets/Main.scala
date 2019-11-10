package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))

  def f: Set = map(singletonSet(1), x => x+1)
  println(contains(f,2))
}
