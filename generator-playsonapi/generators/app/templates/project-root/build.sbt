name := "<%= appname %>"

organization := "<%= organization %>"

version := "<%= version %>"

scalaVersion := "<%= scalaVersion %>"

lazy val `<%= appname %>` = (project in file(".")).enablePlugins(PlayScala)

val playJsonExtensionsVersion = "<%= playJsonExtensionsVersion %>"

val scalaTestVersion = "<%= scalaTestVersion %>"

libraryDependencies ++= Seq(
  guice,
  "ai.x" %% "play-json-extensions" % playJsonExtensionsVersion,
  "org.scalatest" % "scalatest_2.12" % scalaTestVersion)
