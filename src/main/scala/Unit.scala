abstract class Unit{
  val name: String
  val base: Double
}

case class Meter() extends Unit{
  val name = "m"
  val base = 1d
}

case class Centimeter() extends Unit{
  val name = "cm"
  val base = 100d
}

case class Inch() extends Unit{
  val name = "in"
  val base =39.370078740157
}

case class Feet() extends Unit{
  val name = "ft"
  val base =3.2808398950131
}

case class Yard() extends Unit{
  val name = "yd"
  val base =1.0936132983377
}
