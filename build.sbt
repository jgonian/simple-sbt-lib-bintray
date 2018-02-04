scalaVersion := "2.11.12"

lazy val root = (project in file("."))
  .settings(
    organization := "com.github.jgonian",
    name := "simple-sbt-lib-bintray",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.3" % "test" withSources() withJavadoc(),
      "org.scalacheck" %% "scalacheck" % "1.13.4" % "test" withSources() withJavadoc()
    ),
    scmInfo := Some(
      ScmInfo(
        browseUrl = url("https://github.com/jgonian/simple-sbt-lib-bintray"),
        connection = "scm:git:ssh://git@github.com:jgonian/simple-sbt-lib-bintray.git"
      )
    ),
    publishTo := Some("bintray" at "https://api.bintray.com/maven/jgonian/maven-repo/simple-sbt-lib-bintray/;publish=1"),
    credentials += Credentials(Path.userHome / ".sbt" / ".bintray-credentials"),
    publishMavenStyle := true,
    publishArtifact in (Compile, packageDoc) := false, // disable publishing the main API jar
    pomIncludeRepository := { _ => false }
)