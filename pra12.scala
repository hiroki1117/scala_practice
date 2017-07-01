//Stackable modification trait

abstract class IntQueue {
	def get(): Int
	def put(n: Int)
}

import scala.collection.mutable.ArrayBuffer
class BasicIntQueue extends IntQueue {
	private val buf = new ArrayBuffer[Int]
	def get() = buf.remove(0)
	def put(n: Int) { println("Basic"); buf += n }
}

trait Doubling extends IntQueue {
	abstract override def put(n: Int) { println("Doubling"); super.put( 2 * n ) }
}

trait Incrementing extends IntQueue {
	abstract override def put(n: Int) {println("Incrementing");  super.put(n + 1)}
}

trait Filtering extends IntQueue {
	abstract override def put(n: Int) {
		println("Filtering")
		if(n >= 0) super.put(n)
	}
}



val basic = new BasicIntQueue with Filtering with Incrementing
basic.put(2)
//Incrementing
//Filtering
//Basic

class SubIntQueue extends BasicIntQueue with Doubling {
	override def put(n: Int) { println("Sub"); super.put(n) }
}

val sub = new SubIntQueue
sub.put(3)
//Sub
//Doubling
//Basic

val sub2 = new SubIntQueue with Filtering
sub.put(4)
//Filtering
//Sub
//Doubling
//Basic

