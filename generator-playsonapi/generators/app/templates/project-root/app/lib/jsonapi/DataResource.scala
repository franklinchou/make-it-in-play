package lib.jsonapi

import play.api.libs.json.{JsObject, Json}

trait DataResource extends DataIdResource {

  val `type`: String

  val id: String

  val attributes: Option[JsObject]

  val relationships: Option[JsObject]

  val errors: Option[JsObject]

  protected lazy val affiliates: Map[String, Option[JsObject]] =
    Map(
      "attributes" -> attributes,
      "relationships" -> relationships,
      "errors" -> errors,
      "meta" -> meta
    )

  protected val base = Json.obj("type" -> `type`, "id" -> id)

  override val toJsonApi: JsObject = reduce(affiliates, base)

}