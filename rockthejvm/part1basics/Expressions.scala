package com.rockthejvm.part1basics

object Expressions {

  // expressions are structures that can be evaluated to a value
  val meaningOfLife = 40 + 2

  // mathematical expressions: +, -, *, /, bitewise |, &, <<, >>, >>>
  val mathExpression = 2 + 3 * 4

  // comparison expressions: >, >=, <, <=, ==, !=
  val equalityTest = 1 == 2 // Boolean

  // boolean expressions: !, ||, &&
  val nonEqualityTest = !equalityTest

  // instructions vs expression
  // expressions are evaluated, instructions are executed
  // in Scala, we think in term of expressions

  //ifs are expressions
  val aCondition = true
  val anExpression = if(aCondition) 45 else 99

  // code blocks are expressions
  val aCodeBlocks = {
    // local expression
    val localValues = 78
    // expressions...

    // last expression = value of the block
    localValues + 54
  }

  // everything is an expression

  /**
   * Exercise:
   * Without running the code, what do you think these values will print out?
   */
  // 1
  val someValue = {
    2 < 3
  }

  // 2
  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }

  // 3
  val yetAnotherValue = println("Scala")
  // yetAnotherValue is a Unit (equivalent to void in other langages). Unit can has only one value which is ()

  //1 someValue = true
  //2 someOtherValue = 42
  //3 yetAnotherValue = ()

  def main(args: Array[String]): Unit = {
    println(someValue)
    println(someOtherValue)
    println(yetAnotherValue)
  }
}
