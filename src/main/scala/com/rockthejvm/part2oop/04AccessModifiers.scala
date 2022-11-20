package com.rockthejvm.part2oop

object AccessModifiers {

  class Person(val name: String) {
    // a protected method can only be called within the class or within a class that extends the mother class
    // protected restricts the visibility and the access of a method
    // protected = access to inside the class + children classes
    protected def sayHi(): String = s"Hi, my name is $name"
    // private method are only accessible inside the class (not accessible inside the children ones)
    private def watchNetflix(): String = "I'm binge watching my favorite series... "
  }

  class Kid(override val name: String, age: Int) extends Person(name) {
    def greetPolitely(): String = // no modifier = "public"
      sayHi() + "I loge to play!"
  }

  val aPerson = new Person("Alice")
  val aKid = new Kid("David", 5)

  // complication
  class KidWithParents(override val name: String, age: Int, momName: String, dadName: String) extends Person(name) {
    val mam = new Person(momName)
    val dad = new Person(dadName)

    // 
    // def everyoneSayHi(): String =
    //   s"Hi, I'm $name, and here are my parents: " + mam.sayHi() + dad.sayHi()
  }

  def main(args: Array[String]): Unit = {

    println(aKid.greetPolitely())

  }

}
