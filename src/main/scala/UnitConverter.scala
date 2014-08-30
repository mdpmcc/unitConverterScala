import scala.collection.mutable.StringBuilder

object UnitConverter {
  private val unitList = Map[String, Unit]("m"-> new Meter, "cm"-> new Centimeter, "in" -> new Inch, "ft" -> new Feet, "yd"-> new Yard)
  def convert(input : String):String = {
    val inputs = parse(input)
    convert(inputs._1, unitList(inputs._2), unitList(inputs._3))
  }

  def convert(inputValue: Double, inputUnit: Unit, outputUnit: Unit): String = {
    val space = " "
    val equals = "equals"
    val outputValue = inputValue * outputUnit.base / inputUnit.base
    val formalInputValue = if(inputValue == inputValue.toInt) inputValue.toInt.toString else inputValue.toString
    val formalOutputValue = if(outputValue == outputValue.toInt) outputValue.toInt.toString else outputValue.toString
    formalInputValue.toString() + space + inputUnit.name + space + equals + space + formalOutputValue.toString() + space + outputUnit.name
  }

  def parse(inputValue:String):(Double, String, String)={
    val values = inputValue.split(" ")
    if(values.length != 4){
      throw new InvalidInputException("The number of parameters should be always 4")
    }else{
      try{
        val inputValue = values(0).toDouble
        val inputUnit = if (unitList.contains(values(1).toString))values(1) else throw new InvalidInputException("It doesn't support this unit")
        if(!values(2).equalsIgnoreCase("in"))throw new InvalidInputException("Wrong parameter template")
        val outputUnit = if (unitList.contains(values(3).toString))values(3) else throw new InvalidInputException("It doesn't support this unit")
        (inputValue, inputUnit, outputUnit)
      }catch{
        case ex: NumberFormatException => throw new InvalidInputException("The input value should be numeric value")
      }
    }
  }
}