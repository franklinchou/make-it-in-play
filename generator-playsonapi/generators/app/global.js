// Set global version numbers for default packages

module.exports = Object.freeze({
  SCALA_BASE_VERSION: '2.12.x',
  SCALA_VERSION: '2.12.7',
  SBT_VERSION: '1.1.6',
  PLAY_JSON_EXTENSIONS_VERSION: '0.10.0', // ai.x.play-json-extensions
  SCALA_TEST_VERSION: '3.0.5', // org.scalatest.scalatest_2.12  MUST BE COMPATIBLE WITH `scalaBaseVersion`
  SCALA_TEST_PLUS_PLAY_VERSION: '3.1.2', // org.scalatestplus.play.scalatestplus-play
  TYPESAFE_SBT_VERSION: '2.6.20' // com.typesafe.play.sbt-plugin
});
