package controllers

import play.api.mvc._

object Diagnostic extends Controller {
  def ping = Action {
    Ok("ok")
  }

  def name = Action {
    Ok("Scala Code Judge Api")
  }
}
