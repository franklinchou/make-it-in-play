package lib.jsonapi
import play.api.libs.json.{JsObject, Json}

case class DataResources(id: String, `type`: String, drs: Seq[DataResource]) extends DataIdResource {

  val meta: Option[JsObject] =
    Some(
      Json.obj(
        "count" -> drs.size
      )
    )

  override val toJsonApi: JsObject =
    Json.obj(
      topLevelTag ->
        drs.map(dr => dr.toJsonApi)
    )

}