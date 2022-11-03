package com.rockthejvm.part1basics

import scala.annotation.tailrec

object Recursion {

  // Repetition is recursion in Scala
  def sunUntil(n: Int): Int =
    if (n <= 0) 0
    else n + sunUntil(n - 1)
  // In case n is a very high number, it will raise an Exception "StackOverflowError"
  // Because we have a limited stack memory

  //How to overcome this problem

  def sumUntil_v2(n:Int): Int = {
    /*
    sut(10, 0) =
    sut(9, 10) =
    sut(8, 9 + 10) =
    sut(7, 8 + 9 + 10) =
    ...
    sut(0, 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10)
    = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10
    */
    @tailrec
    def sumUntilTailrec(x: Int, accumulator: Int): Int =
      if (x <= 0) accumulator
      else sumUntilTailrec(x - 1, accumulator + x) // TAIL recursion = recursive call occurs LAST in its code path. il the v1 function, sunUntil was evaluated and then added to n --> not the last to be evaluated

    // When the recursive call is last on its call path, the compilator can optimise the code to reuse the same stack frame
    // no further stack frames necessary = no more risk of SO
    // in a tailrec recursive function, one or several accumulators keep track of partial results
    // added @tailrec annotation allows the editor to validate the fact that it is a tail rec and will display an error in case it is not
    sumUntilTailrec(n, 0)
  }

  def sumNumbersBetween(a: Int, b: Int): Int = {
    if (a >= b) 0
    else a + sumNumbersBetween(a + 1, b)
  }

  def sumNumbersBetween_v2(a: Int, b: Int): Int = {
    @tailrec
    def sumTailrec(currentNumber: Int, accumulator: Int): Int =
      if (currentNumber >= b) accumulator
      else sumTailrec(currentNumber + 1, accumulator + currentNumber)

    sumTailrec(a, 0)
  }

  /**
   * Exercises
   * 1. Concatenate a string n times
   * 2. Fibonacci function, tail recursive
   * 3. Is isPrime function tail recursive or not
   */

  def concatenateStringSeveralTimes(a: String, n: Int): String = {
    @tailrec
    def concatenateStringSeveralTimesTailRec(currentRec: Int, acc: String): String =
      if (currentRec >= n) acc
      else concatenateStringSeveralTimesTailRec(currentRec + 1, acc + a)

    concatenateStringSeveralTimesTailRec(0, "")
  }

  def fibonacci(n: Int): Int = {
    @tailrec
    def fibonacciTailrec(i: Int, last: Int, previous: Int): Int =
      if (i >= n) last
      else fibonacciTailrec(i + 1, last + previous, last)
    if (n <= 2) 1
    else fibonacciTailrec(2, 1, 1)
  }

  //isprime is tailRec because the && boolean operator uses 'short-circuit' evaluation.
  // To evaluate `a && b`, if `a` evaluates to `false`, `false` is returned without evaluating `b`. Else, `a && b` value only depends on b value, so it is the last evaluated expression


  def isaPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil( t - 1)
    isPrimeUntil(n/2)
  }

  def main(args: Array[String]): Unit = {
    println(concatenateStringSeveralTimes("Sca", 5))
    println(fibonacci(10))

  }
}
