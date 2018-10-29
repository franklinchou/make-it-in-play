package lib.jsonapi

import play.api.libs.json.{JsObject, Json}

trait DataResource extends DataIdResource {

  val `type`: String

  val id: String

  val attributes: Option[JsObject]

  val relationships: Option[JsObject]

  val errors: Option[JsObject] = None

  protected lazy val affiliates: Map[String, Option[JsObject]] =
    Map(
      "attributes" -> attributes,
      "relationships" -> relationships,
      "errors" -> errors,
      "meta" -> meta
    )

  protected val base: JsObject = Json.obj("type" -> `type`, "id" -> id)

  override val toJsonApi: JsObject = 
    Json.obj("data" -> reduce(affiliates, base))

  lazy val toDataIdResource: JsObject =
    Json.obj(
      "type" -> `type`,
      "id" -> id
    )

}