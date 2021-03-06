import sbtrelease.ReleasePlugin.autoImport.releaseCommitMessage
import sbtrelease.ReleasePlugin.runtimeVersion

logLevel := Level.Debug

scalaVersion := "2.11.12"

crossScalaVersions := Seq("2.11.12", "2.12.4")

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
    publishTo := Some("jgonian-maven-repo" at "https://api.bintray.com/maven/jgonian/maven-repo/simple-sbt-lib-bintray/;publish=1"),
    credentials += Credentials(Path.userHome / ".bintray" / ".credentials"),
    licenses += ("MIT", url("http://opensource.org/licenses/MIT")),
    publishMavenStyle := true,
    publishArtifact in (Compile, packageDoc) := false, // disable publishing the main API jar
    pomIncludeRepository := { _ => false },
    fork := false,
    releaseCommitMessage := s"[sbt-release] Setting version to ${(version in ThisBuild).value}",
    releaseTagName := s"${name.value}-${runtimeVersion.value}"
)
