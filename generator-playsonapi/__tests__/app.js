'use strict';
const path = require('path');
const assert = require('yeoman-assert');
const helpers = require('yeoman-test');
var global = require('./../generators/app/global');

describe('generator-playsonapi:app', () => {
  beforeAll(() => {
    return helpers.run(path.join(__dirname, '../generators/app')).withPrompts({
      name: 'test',
      organization: 'com.test',
      projectVersion: '0.0.1',
      sbtVersion: global.SBT_VERSION,
      playJsonExtensionsVersion: global.PLAY_JSON_EXTENSIONS_VERSION,
      scalaTestVersion: global.SCALA_TEST_VERSION,
      scalaTestPlusPlayVersion: global.SCALA_TEST_PLUS_PLAY_VERSION,
      typesafeSbtPluginVersion: global.TYPESAFE_SBT_VERSION
    });
  });

  it('creates files', () => {
    assert.file(['test/build.sbt']);
  });
});
