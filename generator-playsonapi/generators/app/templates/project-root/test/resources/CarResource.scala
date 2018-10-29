package test.resources

import java.util.UUID

import lib.jsonapi.DataResource
import play.api.libs.json.{JsObject, _}
import test.models.CarModel

object CarResource {

  final val resourceType = "car-resource"

  // Place an implicit reader here

}


import test.resources.CarResource.resourceType

/**
  * An example [[DataResource]]
  *
  * A [[DataResource]] should always accept, as parameters, the model or models
  * to which this resource will marshall.
  *
  * @param model
  */
case class CarResource(model: CarModel) extends DataResource {

  lazy val `type`: String = resourceType

  lazy val id: String = UUID.randomUUID().toString

  lazy val attributes: Option[JsObject] =
    Some(
      Json.obj(
        "make" -> model.make,
        "model" -> model.model,
        "year" -> model.year,
        "color" -> model.color,
        "owned" -> model.owned,
        "leased" -> model.leased
      )
    )

  lazy val relationships: Option[JsObject] = None

  lazy val meta: Option[JsObject] = None

}
