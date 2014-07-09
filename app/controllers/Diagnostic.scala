package controllers

import play.api.mvc._


/**
 * Created by coney on 7/9/14.
 */
object Diagnostic extends Controller {
  def ping = Action {
    Ok
  }

  def name = Action {
    Ok("Scala Code Judge Api")
  }


}
