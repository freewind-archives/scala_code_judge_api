import org.junit.runner._
import org.specs2.mutable._
import org.specs2.runner._
import play.api.libs.json.Json
import play.api.test.Helpers._
import play.api.test._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
@RunWith(classOf[JUnitRunner])
class DiagnosticSpec extends Specification {

  "Diagnostic" should {

    "render the ping page with 200 OK" in new WithApplication{
      val pingResponse = route(FakeRequest(GET, "/diagnostic/ping")).get

      status(pingResponse) must equalTo(OK)
      contentAsString(pingResponse) must equalTo("ok")
    }

    "render the home page" in new WithApplication{
      val name = route(FakeRequest(GET, "/diagnostic/name")).get
      status(name) must equalTo(OK)
      contentAsString(name) must equalTo("Scala Code Judge Api")
    }

    "render the hello page" in running(FakeApplication()){
      val username = "test json"
      val json = Json.obj("name" -> username)
      val Some(helloInfo) = route(FakeRequest(POST, "/diagnostic/hello").withJsonBody(json))

      status(helloInfo) must equalTo(OK)
      contentAsJson(helloInfo) must equalTo(Json.obj("hello" -> username))
    }
  }
}
