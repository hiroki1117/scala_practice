
//Support Constractor

import java.io.File
import java.net.{URL, URISyntaxException}

class FileResource(val url: URL){
	//support constractor
	def this(file: File) = this(file.toURL)
	def this(fileName: String) = this(new File(fileName))
	
	//how to instance. have three pattern.
	//new FileResource(new URL(...))
	//new FileResource(new File(...))
	//new FileResource("...")
}




//trait

trait UseCreditCard {
	var cardNumber: Option[String] = None
	def printCardNumber {
		println(cardNumber.getOrElse("No card"))
	}
}

trait UseBankTransfer {
	var accountNumber: Option[String] = None
	def printAccountNumber {
		println(accountNumber.getOrElse("No account"))
	}
}




//----

abstract class Party(val name: String){
	var zip: Option[String] = None
	var prefecture: Option[String] = None
	var city : Option[String] = None
	def address: String = {
		(for (Some(s) <- List(zip, prefecture, city)) yield s)
		.mkString(" ")
	}
	var tel: Option[String]
}


class Person(aName: String) extends Party(aName) with UseCreditCard{
	var birthday: Option[(Int, Int, Int)] = None
	var tel: Option[String] = None
}

class Company(aName: String) extends Party(aName) with UseBankTransfer{
	var chargePerson: Option[Person] = None
	override def tel: Option[String] = {
		chargePerson.flatMap(_.tel)
	}
	
	override def tel_=(value: Option[String]) {
		if(chargePerson.isDefined){
			chargePerson.get.tel = value
		}
	}
}

//function
def printTel(party: Party){	println(party.address)	}

//instance
val hiroki = new Person("hiroki"){
	zip = Some("222-0000")
	prefecture = Some("Ibaraki")
	city = Some("Mitoi")
	birthday = Some((1995, 11, 17))
	tel = Some("080-1287-9119")
	cardNumber = None
}

hiroki.printCardNumber
printTel(hiroki)


val mcc = new Company("MCC"){
	zip = Some("555-0000")
	city = Some("Tsugashima")
	chargePerson = Some(hiroki)
	accountNumber = Some("123-456-78910")
}

mcc.printAccountNumber















































