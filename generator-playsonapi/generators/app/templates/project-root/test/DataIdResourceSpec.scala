package test

import org.scalatest.FunSpec
import play.api.libs.json.Json
import models.MockCarModel.model
import resources.CarResource

class DataIdResourceSpec extends FunSpec {

  val resource = CarResource(model)
  val actual = resource.toJsonApi
  val actualId = resource.toDataIdResource

  describe("A data id resource") {
    it("should be obtained from a data resource") {
      val expected =
        Json.obj("data" ->
          Json.obj(
            "type" -> "car-resource",
            "id" -> resource.id,
            "attributes" -> Json.obj(
              "make" -> "BMW",
              "model" -> "E90",
              "year" -> 2008,
              "color" -> "Black",
              "owned" -> true,
              "leased" -> false
            )
          )
        )

      assert(expected == actual)
    }

    it("should marshall to json api") {
      val expected =
        Json.obj(
          "type" -> "car-resource",
          "id" -> resource.id
        )

      assert(expected == actualId)
    }
  }

}