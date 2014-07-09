package controllers

import play.api.mvc._
import play.libs.Json

object Diagnostic extends Controller {
  def ping = Action {
    Ok
  }

  def name = Action {
    Ok("Scala Code Judge Api")
  }
}
