package test.models

case class CarModel(make: String,
                    model: String,
                    year: Int,
                    color: String,
                    owned: Boolean) {

  lazy val leased: Boolean = !owned

}