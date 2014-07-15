package controllers

import play.api.mvc._
import play.api.libs.json.{JsPath, JsError, Json}

object Diagnostic extends Controller {
  implicit val rds = (JsPath \ 'name).read[String]

  def ping = Action {
    Ok("ok")
  }

  def name = Action {
    Ok("Scala Code Judge Api")
  }

  def hello = Action(parse.json) {
    request =>
      request.body.validate[String].map {
        case name => Ok(Json.obj("hello" -> name))
      }.recoverTotal({
        e => BadRequest("Error: " + JsError.toFlatJson(e))
      })
  }
}
