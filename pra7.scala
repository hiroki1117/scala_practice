//List	foreach,map,filter,for,find,exisits

val nums = 1 to 10  //Range


//5,7,...21,23
val f1 = for(num <- nums) yield {
		num*2 +3
	}

f1.head   // 5
f1.tail   // 7, .... 23
f1.init   // 5,....21
f1.last   // 23



val f2 = f1.filter(_ >10)   //List
f2.exists(_ == 20 )	    // false

val f3 = f2.map(n => n * n)
f3.foreach(n => println(n))

val lang = List("Java", "Ruby", "Python")
val result = for(l <- lang if l.startsWith("J")) yield l
lang.foreach(s => println(s.toUpperCase))



//return function
def repeat(n: Int) = { (s: String) => s * n }
//repeat(3)(Strng)
println(repeat(3)("hello"))