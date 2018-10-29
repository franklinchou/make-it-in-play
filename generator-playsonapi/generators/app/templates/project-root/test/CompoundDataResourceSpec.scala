package test

import org.scalatest.FunSpec
import play.api.libs.json.Json
import test.models.MockFleetModel.model
import test.resources.FleetResource


class CompoundDataResourceSpec extends FunSpec {

  describe("A compound data resource") {
    it("should marshall to jsonapi") {
      val resource = FleetResource(model)
      val actual = resource.toJsonApi

      val expected =
        Json.obj(
          "data" ->
            Json.obj(
              "type" -> "fleet-resource",
              "id" -> resource.id,
              "attributes" -> Json.obj("name" -> "focus-fleet-1"),
              "meta" -> Json.obj("count" -> 3)
            ),
          "included" -> actual.value("included")
        )

      assert(actual == expected)
    }
  }

}
