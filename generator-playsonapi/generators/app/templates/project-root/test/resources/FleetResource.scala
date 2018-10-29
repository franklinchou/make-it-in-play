package test.resources

import java.util.UUID

import lib.jsonapi.{CompoundDataResource, Resource2IncludedResource}
import play.api.libs.json.{JsObject, Json}
import test.models.FleetModel

object FleetResource {

  final val resourceType = "fleet-resource"

  // Place an implicit reader here

}

import test.resources.FleetResource.resourceType


case class FleetResource(model: FleetModel) extends CompoundDataResource {

  lazy val `type`: String = resourceType

  lazy val id: String = UUID.randomUUID().toString

  lazy val attributes: Option[JsObject] =
    Some(
      Json.obj(
        "name" -> model.name
      )
    )

  lazy val relationships: Option[JsObject] = None

  /**
    * In a compound document, all included resources MUST be represented as an
    * array of resource objects in a top-level included member.
    */
  lazy val included: List[JsObject] =
    model
      .cars
      .map(c => CarResource(c))
      .map(resource => Resource2IncludedResource(resource))
      .map(resources => resources.toJsonApi)
      .toList
}
