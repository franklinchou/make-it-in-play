package test.models

object MockFleetModel {

  val mockFordFocus =
    CarModel(
      "Ford",
      "Focus",
      2018,
      "Gray",
      owned = false
    )

  val cars: Seq[CarModel] = (0 to 2).map(_ => mockFordFocus)

  val model = FleetModel("focus-fleet-1", cars)

}
