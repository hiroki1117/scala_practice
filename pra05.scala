//Pattern Matching

def typePattern(input: Any){
	input match{
		case n: Int => println("Int = "+ n)
		case d: Double => println("Double = " + d)
		case s: String => println("String = " + s)
		case _ => println("unknown = " + input)
	}
}

def sequencePattern(input: Any){
	input match{
		case List(a) => println("List " +a)
		case List(a, b) => println("List" + a + b)
		case List(a, b, c) => println("List" +a +b +c)
		case _ => println("undefined"+ input)
	}
}

def tuplePattern(input: Any){
	input match{
		case (a, b, c) => println("three")
		case (a, b) => println("two")
		case (a) => println("one")
	}
}

//Pattern of var
val mailRegex = """([\w]+)@([\w.]+)""".r
val mailRegex(user, host) = "hiroki@abc.com"
println("user = " + user + " host = " + host)

//Pattern of For
val list = List((1,3), (3, 5), (5, 7))
for ((x,y) <- list ) println(x + ":" + y)

val contacts = List("hiroki@abc", "http://yahoo.co.jp", "miki@abc")

for (mailRegex(user, host) <- contacts ) println(user + ":" + host)



def regexDay(input: Any) {
	//capture year
	val regex = """(\d{4})-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}""".r
	
	input match{
		case regex(x) => println(""+x)
	}
}








