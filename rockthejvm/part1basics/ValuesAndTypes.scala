package com.rockthejvm.part1basics

object ValuesAndTypes {

  // values or variable
  val meaningOfLike: Int = 42

  // assigning
  // meaningOfLike = 45
  // this is NOT possible because value in Scala are unmutable, so there cannot be re-assigned

  // type inference (Scala can detect the type automatically for value and for function return also)
  val onInteger = 67 // : Int is optional

  //common type
  val aBoolean: Boolean = false
  val aChar: Char = 'a' // simple quote
  val aString: String = "scala" // double quote
  val anInt: Int = 78 // 4 bytes
  val aShort: Short =  5236 // 2 bytes
  val aLong: Long = 4589865346L /// 8 bytes ; L at the end to make a different between Int and Long
  val aFloat: Float = 5.4f // 4 bytes ; f at the end
  val aDouble: Double = 3.14 // 8 bytes

  // type mismatch: Scala will detect if the declared type and the value given to the value are different
  // val succ(x: Int) = x + x

  def main(args: Array[String]): Unit = {

  }
}
