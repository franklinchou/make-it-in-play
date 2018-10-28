package controllers

import javax.inject._
import play.api.Configuration
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}


@Singleton
class HomeController @Inject()(config: Configuration,
                               ws: WSClient,
                               cc: ControllerComponents)
                              (implicit ec: ExecutionContext) extends AbstractController(cc) {

  // Health endpoint
  def index = Action.async { implicit request =>
    Future {
      val json =
        Json.obj(
          "application" -> config.get[String]("app.name"),
          "environment" -> config.get[String]("app.env"),
          "debug-mode" -> config.get[String]("app.debug")
        )
      Ok(json)
    }
  }

}