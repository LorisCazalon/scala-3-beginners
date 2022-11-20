package com.rockthejvm.part2oop
import scala.language.postfixOps

object MethodNotation {

  class Person(val name: String, val age: Int, favoriteMovie: String) {
    infix def likes(movie: String): Boolean =
      movie == favoriteMovie

    infix def +(person: Person): String =
      s"${this.name} is hanging out with ${person.name}"

    infix def +(nickname: String): Person =
      new Person(s"${this.name} $nickname", this.age, this.favoriteMovie)

    infix def !!(progLangage: String): String = // ?, !, <<, >> can be used as method name
      s"$name wonders how can $progLangage be so cool!"

    // prefix position
    // unary ops: -, +, ~, !
    // do not forget space between the operator and the double dots
    // cannot have any argument
    def unary_- : String =
      s"$name's alter ego'"

    def unary_+ : Person =
      new Person(this.name, this.age + 1, this.favoriteMovie)

    // postfix position
    // does not take any args or any parenthesis
    def isAlive: Boolean = true

    def apply(): String =
      s"Hi, my name is $name, i really enjoy $favoriteMovie"

    def apply(count: Int): String =
      s"$name watched $favoriteMovie $count times"
  }

  val mary = new Person("Mary", 34, "Inception")
  val john = new Person("John", 36, "Fight Club")

  val negativeOne = -1

  /**
   * Exercises:
   *   - a + operator on the Person class that returns a person with a nickname
   *     mary + "the rockstar" => new person("Mary the rockstar", ...)
   *   - a unary + operator that return the person's age
   *     +mary => new Person(..., age + 1)
   *   - on apply method with an int arg
   *     mary.apply(2) => "Mary Watched Inception 2 times"
   */

  val alice = new Person ("Alice", 18, "Back to the future")

  def main(args: Array[String]): Unit = {

    println(mary.likes("Fight Club"))
    // infix notation - for method with ONE argument
    println(mary likes "Fight Club") // identical

    // "operator" = plain method in scala
    println(mary + john)
    println(mary.+(john)) // identical

    println(2 + 3)
    println(2.+(3)) // indentical

    println(mary !! "Scala")

    //prefix position
    println(-mary)
    print(mary.unary_-) // identical

    //postfix position
    println(mary.isAlive)
    println(mary isAlive) // discourage - need an import to work: import scala.language.postfixOps

    //apply is special
    print(mary.apply())
    println(mary()) // same as previous line

    //exercise
    val funnierAlice = alice + "the rockstar"
    println(funnierAlice.name)

    val olderAlice = +alice
    println(olderAlice.age)

    println(alice.apply(1000))
  }
}
