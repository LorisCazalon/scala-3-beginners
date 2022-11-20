package com.rockthejvm.part2oop

object Inheritance {

  class Animal {
    val creatureType = "wild"
    def eat(): Unit = println("nomnomnom")
  }

  class Cat extends Animal {
    def crunch() = {
      eat()
      println("crunch, crunch")
    }
  }

  val cat = new Cat

  class Person(val name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  // because Person have an aux constructor, we need to specify from with constructor the child class inherit from
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age) { // must specify super constructor
  }

  // overriding
  class Dog extends Animal {
    override val creatureType: String = "domestic"
    override def eat(): Unit = println("mmm, I like this bone.")

    // popular overridable method
    override def toString: String = "a dog"
  }

  // subtype polymorphism
  val dog: Animal = new Dog
  dog.eat() // the most specific method will be called

  // overloading vs overriding
  class Crocodile extends Animal {
    override val creatureType = "very wild"
    override def eat(): Unit =
      println("I can eat anything, I'm a croc")
    // overloading : multiple methods with the same name, but different signatures
    // different signature =
    //    different argument list (different number of args + different arg types)
    //    + different return type (optional)
    def eat(animal: Animal): Unit = println("I'm eating this poor fella")
  }

  /*
    Exercise: Is the following overloading are correct or not ?
    def eat(dog: Dog): Unit = println("eating a dog")
      -> correct. But if we call it with the dog instance declared with the Animal type, to previous one will be called.
                  With a Dog instance typed as a Dog, this one will be called
    def eat(person: Person): Unit = println("I'm eating a human with the name ${person.name}.")
      -> correct
    def eat(person: Person, dog: Dog): Unit = println("I'm eating a human AND the dog")
      -> correct
    def eat(): Int = 45
      -> not correct because the crocodile already has a eat method with the same signature
    def eat(person: Person, dog: Dog): Unit = println("I'm eating a human AND the dog")
      -> correct because the compiler will be able to know if it could use the one with the arg in the different order
  */


  def main(args: Array[String]): Unit = {
    cat.eat()
    cat.crunch()

    println(dog) //println(dog.toSting())
  }

}
