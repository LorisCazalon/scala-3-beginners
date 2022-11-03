package com.rockthejvm.part1basics

object Functions {

  // function = reusable piece of code that you can invoke with some argument and return a result
  def aFunction(a: String, b: Int): String = {
    a + " " + b.toString()
  }

  // function invocation
  val aFunctionInvocation = aFunction("Scala", 999)

  def aNoArguementFunction(): Int = 45
  def aParameterListFunction: Int = 45

  // function can be recursive
  def stringConcatenation(str: String, n: Int): String = {
    if (n == 0) ""
    else if (n == 1) str
    else str + stringConcatenation(str, n - 1)
  }

  val scalax3 = stringConcatenation("Scala", 3)

  // When you need loops, use RECURSION

  // "void" functions
  def aVoidFunction(aString: String): Unit =
    println(aString)

  def computeDoubleStringWithSideEffect(aString: String): String = {
    aVoidFunction(aString) // Unit
    aString + aString // meaningful value
  } // in Scala, side effects are discouraged

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n+1)
  }

  // for recursive function, always specify the return type
  // Scala cannot do type inference because the type of the function return depend on itself
  /**
   * Exercise
   * 1. A greeting function (name, age) => "Hi my name is $name and i am $age years old."
   * 2. Factorial function n => 1 * 2 * 3 * ... * n
   * 3, Fibonacci function:
   *      fib(1) = 1
   *      fib(2) = 1
   *      fib(3) = 1 + 1
   *      fib(n) = fib(n-1) + fib(n-2)
   * 4. Tests if a number is a prime
   */

  def greetingFunction(name: String, age: Int): String =
    "Hi my name is " + name + " and I am " + age + " years old."

  def factorialFunction (n: Int): Int = {
    if (n <= 0) 0
    else if (n == 1) 1
    else n * factorialFunction(n - 1)
  }

  def fibonacciFunction(n: Int): Int = {
    if (n <= 0) 0
    else if (n == 1) 1
    else if (n == 2) 1
    else fibonacciFunction(n-1) + fibonacciFunction(n-2)
  }

  def isaPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil( t - 1)
    isPrimeUntil(n/2)
  }

  def main(args: Array[String]): Unit = {
    println(scalax3) //ScalaScalaScala
    println(greetingFunction("Loris", 33))
    println(factorialFunction(6))
    println(fibonacciFunction(6))
    println(isaPrime(3))
    println(isaPrime(7))
    println(isaPrime(10))
    println(fibonacciFunction(10))

  }
}
