package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    println(balance("(Hola carambola)".toList))

  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if (c == 0 || r == 0 || c == r) 1
      else pascal(c-1,r-1) + pascal(c,r-1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def loop(acc: Int, chars: List[Char]): Boolean = {
        if (chars.isEmpty || acc < 0)  (acc == 0)
        else if (chars.head == '(') loop(acc+1, chars.tail)
        else if (chars.head == ')') loop(acc-1, chars.tail)
        else loop(acc, chars.tail)
      }
      loop(0,chars)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      def loop(acc: Int, money: Int, coins: List[Int]): Int = {
        if (coins.isEmpty) 0
        else if (money == 0) acc + 1
        else if (coins.tail.isEmpty){
          if (money - coins.head >= 0) loop(acc, money - coins.head, coins)
          else acc
        }
        else if (money - coins.head >= 0) loop(acc, money - coins.head, coins) + loop(acc, money, coins.tail)
        else loop(acc, money, coins.tail)
      }
      loop(0, money, coins)
    }
  }
