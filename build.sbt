name := "scala_code_judger_api"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache
)     

play.Project.playScalaSettings

mappings in Universal ++=
  (baseDirectory.value / "scripts" * "*" get) map
    (x => x -> ("scripts/" + x.getName))

mappings in Universal ++= Seq(baseDirectory.value / "build_version" -> "build_version")
