package com.rockthejvm.part2oop

object OOBasics {

  // in scala, the constructor argument = class parameters and the fields of the class are totally distinguished
  // in scal, the list of the constructor args is called the constructor signature
  // to define a constructor argument as a field, we need to add a "val" before it's name

  // this class has no field
  class Personv0(name: String, age: Int)

  // This class has name as field
  class Person(val name: String, age: Int) { // constructor signature
    // class body

    // fields defined in class body
    val allCaps = name.toUpperCase()

    // methods
    // We can declare several method in the same class with the same name
    def greet(name: String): String =
      s"${this.name} says: Hi $name" //in that case, to disambiguate name arg, we use this key word this

    // signature differs (numbers and / or types of args)
    // OVERLOADING
    def greet(): String =
      s"Hi everybody, my name is $name."

    // aux constructor - rarely used in scala because it is the same as use default args
    def this(name: String) =
      this(name, 0)

    def this() =
      this("John Doe")
  }
  val aPerson: Person = new Person("John", 26)
  val john: String = aPerson.name
  val johnSayHiToDaniel = aPerson.greet("Daniel")
  val johnSayHi = aPerson.greet()
  val genericPerson = new Person() // use aux constructor


  def main(args: Array[String]): Unit = {
    println(johnSayHiToDaniel)

    val charlesDickens = new Writer("Charles", "Dickens", 1822)
    val novel = new Novel ("Great expectations", 1861, charlesDickens)
    val newEdition = novel.copy(1871)

    println(charlesDickens.fullName)
    println(novel.authorAge)
    println(novel.isWrittenBy(charlesDickens))
    println(newEdition.authorAge)

    val counter = new Counter()
    counter.print() //0
    counter.inc().print() //1
    counter.inc()
    counter.print() //0
  }
}

/**
 Exercise: imagine we are creating a backend for a book publishing house
 Create a novel and a writer class.

 Writer: first name, last name, year
   - method: fullname

 Novel: name, year of release, author
   - authorAge -> return age of the author at the time of the publishing of the novel
   - isWrittenBy(author) -> return a boolean
   - copy (new year of release) = new instance of novel

 */

class Writer(firstName: String, lastName: String, val yearOfBirth: Int):
  def fullName: String = s"$firstName $lastName"

class Novel(title: String, val yearOfRelease: Int, author: Writer):
  def authorAge: Int =
    yearOfRelease - author.yearOfBirth

  def isWrittenBy(author: Writer): Boolean =
    author == this.author

  def copy(newYear: Int): Novel =
    new Novel(this.title, newYear, this.author)

/**
 * Exercise 2: an immutable counter class
 *   - constructed with initial count
 *   - increment / decrement => NEW instance of counter - we don't have any variable so we have to do that
 *   - increment(n)/decrement(n)  => NEW instance of counter
 *   - print()
 *
 * Benefits:
 *   - well in distributed environments
 *   - easier to read and understand code
 */

class Counter(count: Int = 0) {

  def inc(n: Int = 1): Counter =
    if (n <= 0) this
    new Counter(count + n)

  def dec(n: Int = 1): Counter =
    if (n <= 0) this
    else if (count - n <= 0) new Counter()
    else new Counter(count - n)

  def print(): Unit =
    println(s"current count: $count")
}





