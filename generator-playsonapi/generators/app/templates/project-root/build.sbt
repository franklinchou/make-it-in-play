name := "<%= appname %>"

organization := "<%= organization %>"

version := "<%= version %>"

scalaVersion := "<%= scalaVersion %>"

lazy val `<%= appname %>` = (project in file(".")).enablePlugins(PlayScala)

val playJsonExtensionsVersion = "<%= playJsonExtensionsVersion %>"

val scalaTestVersion = "<%= scalaTestVersion %>"

val scalaTestPlayVersion = "<%= scalaTestPlusPlayVersion %>"

resolvers ++= Seq(
  "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"
)

libraryDependencies ++= Seq(
  guice,
  "ai.x" %% "play-json-extensions" % playJsonExtensionsVersion,
  "org.scalatest" % "scalatest_2.12" % scalaTestVersion % Test,
  "org.scalatestplus.play" %% "scalatestplus-play" % scalaTestPlayVersion % Test
)
