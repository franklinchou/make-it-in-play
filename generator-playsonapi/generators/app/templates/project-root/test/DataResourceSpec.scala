package test

import org.scalatest.FunSpec
import play.api.libs.json.Json
import test.models.MockCarModel.model
import test.resources.CarResource

class DataResourceSpec extends FunSpec {

  describe("A data resource") {
    it("should marshall to jsonapi") {
      val resource = CarResource(model)
      val actual = resource.toJsonApi

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

      assert(actual == expected)
    }
  }
}
