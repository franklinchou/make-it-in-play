name := "<%= appname %>"

organization := "<%= organization %>"

version := "<%= version %>"

scalaVersion := "<%= scala %>"

lazy val `<%= appname %>` = (project in file(".")).enablePlugins(PlayScala)

resolvers ++= Seq(
  "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"
)

libraryDependencies ++= Seq(
  guice,
  "ai.x" %% "play-json-extensions" % "0.10.0",
  "org.scalatest" % "scalatest_2.12" % "3.0.5" % Test,
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
)
