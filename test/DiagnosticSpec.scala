import org.junit.runner._
import org.specs2.mutable._
import org.specs2.runner._
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

    "render the index page" in new WithApplication{
      val home = route(FakeRequest(GET, "/diagnostic/ping")).get

      status(home) must equalTo(OK)
    }
  }
}
