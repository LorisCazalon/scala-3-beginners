package com.rockthejvm.part1basics

object StringOps {

  val aString: String = "Hello, I am learning Scala"

  // Sting function
  val secondChar: Char = aString.charAt(1)
  val firstWord: String = aString.substring(0, 5) // "Hello"
  val words: Array[String] = aString.split("") // Array("Hello", "I", "am", "learning", "Scala")
  val startWithHello: Boolean = aString.startsWith("Hello") // true
  val allDashes: String = aString.replace(' ', '-')
  val allUppercase = aString.toUpperCase() // also .toLowerCase
  val nChars = aString.length // no parenthesis

  //other functions
  val reversed = aString.reverse
  val aBunchOfChars = aString.take(10) // return the 10 first chars of the strings

  //parse to numeric
  val numberAsString = "2"
  val number = numberAsString.toInt

  //interpolation
  val name = "Alice"
  val age = 12
  val greeting = "Hello, I'm " + name + "and I am " + age + " years old."
  val greetingv2 = s"Hello, I'm $name and I am $age years old."
  val greetingv3 = s"Hello, I'm $name and I will be turning ${age + 1} years old."

  // f-interpolation = format interpolation
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute." // f-interpolation allows to specify the format

  //raw interpolation: ignore escaped sequences like \n
  val escapes = "This is a \n newline"
  val escapesv2 = raw"This is a \n newline"


  def main(args: Array[String]): Unit = {

    println(myth)
    println(escapes)
    println(escapesv2)

  }

}
