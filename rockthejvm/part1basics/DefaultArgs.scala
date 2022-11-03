package com.rockthejvm.part1basics

import scala.annotation.tailrec

object DefaultArgs {

  // instead of wrapping the sumUntilTailRec function in another function, we can give a default value for the accumulator
  @tailrec
  def sumUntil(x: Int, accumulator: Int = 0): Int =
    if (x <= 0) accumulator
    else sumUntil(x - 1, accumulator + x) // TAIL recursion = recursive call occurs LAST in its code path. il the v1 function, sunUntil was evaluated and then added to n --> not the last to be evaluated

  val sumUntil100 = sumUntil(100)

  def savePicture(dirPath: String, name: String, format: String,width: Int, height: Int): Unit =
    println("Saving Picture in format " + format + " in path " + dirPath)

  def main(args: Array[String]): Unit = {

  }

}
