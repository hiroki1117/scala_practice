val parttern = """\d{2}-\d{4}"""

val result1 = "83-8351".matches(parttern)
val result2 = "777-2983".matches(parttern)

println(result1)
println(result2)

//---

val source = "a,b\tc"
//regex  crate by String#r method
val regex = "[,\t]".r

//split by regex
val result: Array[String] = regex.split(source)

for(char <- result){
	print(char+"\t")
}

println()

val source2 = "123 to 456"
val regex2 = """\d{3}""".r

val list = regex2.findAllIn(source2).toList
//list.foreach{s => println("in list"+ s) }
regex2.findAllIn(source2).foreach{ s: String => println(s)}


//---
val regex3 = """<a href="(.*?)">(.*?)</a>""".r
val source3 = """
	<a href="google.com">Google</a>
	<a href="yahoo.co.jp">Yahoo</a>
	"""
regex3.findAllIn(source3).matchData.foreach{m=>
	println("group0:" + m.group(0))	//All
	println("group1:" + m.group(1)) 
	println("group2:" + m.group(2))
}















