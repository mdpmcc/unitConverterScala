import org.scalatest.FunSuite

class UnitConverter$Test extends FunSuite {
  test("Testing converter function, valid input"){
    val actual = UnitConverter.convert("10 cm in m")
    assert(actual=="10 cm equals 0.1 m")

    val actual1 = UnitConverter.convert("1000 cm in ft")
    assert(actual1=="1000 cm equals 32.808398950131 ft")
 
    val actual3 = UnitConverter.convert("100 mm in m")
    assert(actual=="100 mm equals 0.1 m")
  }

  test("Testing inner converter function, valid input"){
    val actual = UnitConverter.convert(10, new Centimeter, new Meter)
    assert(actual=="10 cm equals 0.1 m")
  }

  test("Testing parser function, 10 cm in m in correct format"){
    val actual = UnitConverter.parse("10 cm in m")
    assert(10 == actual._1)
    assert("cm" == actual._2)
    assert("m" == actual._3)
  }

  test("Testing parser function with several invalid inputs"){
    intercept[InvalidInputException] {
      UnitConverter.parse("10 cm on m")
    }

    intercept[InvalidInputException] {
      UnitConverter.parse("m cm in m")
    }

    intercept[InvalidInputException] {
      UnitConverter.parse("10 dm in m")
    }

    intercept[InvalidInputException] {
      UnitConverter.parse("10 cm in dm")
    }

    intercept[InvalidInputException] {
      UnitConverter.parse("10 cm in m i")
    }
  }
}
