//collection
//scala.collection.mutable.{ListBuffer, ArrayBuffer}
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable

val seasonsBuff = new ListBuffer[String]
seasonsBuff ++= List("spring", "summar", "fall", "winter")
seasonsBuff(3) = "autumn"
seasonsBuff.foreach(season => println(season))

//ListBuffer to List/Array
//seasonsBuff.toList seasonsBuff.toArray
val array = seasonsBuff.toArray
array.foreach(season => println(season))


val seasonsBuff2 = new ArrayBuffer[String]
seasonsBuff2 ++= Array("spring", "summar", "fall", "winter")
seasonsBuff2.foreach(season => println(season+" from ArrayBuff"))
seasonsBuff2 -= "summar"
seasonsBuff2.remove(1)
seasonsBuff2.foreach(season => println(season))


//Map

val map = Map(1 -> "one", 2 -> "two", 3 -> "three")
map.get(1) match{
case Some(label) => println(label)
case None => println("none")
}

for((key, value) <- map){
	println("key = %d, value = %s".format(key, value))
}

val num = mutable.Map[Int, String]()
num += 1 -> "one"
val numList = List(2 -> "two", 3 -> "three")
num ++= numList
num.foreach(n => println(n))


//Set

val numSet = Set(1,2,3,4,5)
val numSet2 = Set.empty ++ List(1,2,3,4,5,6,7)

val mutableSet = mutable.Set[Int]()
mutableSet ++= List(1,2,3,4,5,6)
mutableSet ++= numSet2
mutableSet.foreach(n => println(n))





