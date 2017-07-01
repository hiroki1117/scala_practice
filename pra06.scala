import scala.io.StdIn
import scala.io.Source

object Main {
	def main(args: Array[String]) ={
	val strAry = StdIn.readLine.split(' ')
	println(strAry.sorted.mkString(" "))
	}
}

def printSource(filename: String){
	var number = 1
	for(line <- Source.fromFile(filename, "utf-8").getLines){
		println(number + ":" + line)
		number += 1
	}
}

