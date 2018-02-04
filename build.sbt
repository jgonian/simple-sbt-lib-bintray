scalaVersion := "2.11.12"

lazy val root = (project in file("."))
  .settings(
    organization := "com.github.jgonian",
    name := "template-simple-sbt-lib",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.3" % "test" withSources() withJavadoc(),
      "org.scalacheck" %% "scalacheck" % "1.13.4" % "test" withSources() withJavadoc()
    ),
    scmInfo := Some(
      ScmInfo(
        browseUrl = url("https://github.com/jgonian/simple-sbt-lib-bintray"),
        connection = "scm:git:ssh://git@github.com:jgonian/simple-sbt-lib-bintray.git"
      )
    )
  )