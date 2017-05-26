import java.io._
object CurringLesson extends App{
  def withPrintWriter(file:File)(op: PrintWriter => Unit) = {
    val writer = new PrintWriter(file)
    try{
      op(writer)
    }finally{
      writer.close
    }
  }

  val fileName = """C:\Users\anyone"""
  val file = new File(fileName)
  withPrintWriter(file){
    _.println(new java.util.Date)
  }
}
