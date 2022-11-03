package com.rockthejvm.part1basics

object CBNvsCBV {

  //In Scala, there is 2 ways to pass arg to a function: call by name AND call by value

  // CBV = call by value = arguments are evaluated before function invocation
  def aFunction(arg: Int): Int = arg + 1
  val aComputation = aFunction(23 + 67)
  // here the expression 23 + 67 is evaluated before the function is invoked
  // THis is the default way to do it, and the one uses in most langages

  // CBN = call by name = arguments are passed LITERALLY
  def aByNameFunction(arg: => Int): Int = arg + 1
  val anotherComputation = aByNameFunction(23 + 67)
  //23 + 67 is passed LITERALLY to the function so arg in replaced by `23 + 67`
  // even if the result is the samen we have a difference in term of when the arg is evaluated.
  // in the CBN function, the arg is evaluated only when it is used, it is evaluated at every reference
  // in case the arg is not used, it will never be evaluated

  def printTwiceByValue(x: Long): Unit = {
    println("By value: " + x)
    println("By value: " + x)
  }

  /*
  Call by value:
    - value is computed before call
    - same value used everywhere
  Call by name:
    - expression is passed literally
    - Delayed evaluation of the argument
    - arg is evaluated every time it is used
  */

  def printTwiceByName(x: => Long): Unit = {
    println("By value: " + x)
    println("By value: " + x)
  }

  // the arrow means it is a call by name function
  def main(args: Array[String]): Unit = {
    println(aComputation)  //91
    println(anotherComputation)  //91, same value
    printTwiceByValue(System.nanoTime()) // will print twice the same number
    printTwiceByName(System.nanoTime()) // will print 2 diff numbers
  }
}
