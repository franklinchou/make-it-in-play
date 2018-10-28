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
      sbtVersion: global.sbtVersion,
      playJsonExtensionsVersion: global.playJsonExtensionsVersion,
      scalaTestVersion: global.scalaTestVersion,
      scalaTestPlusPlayVersion: global.scalaTestPlusPlayVersion,
      typesafeSbtPluginVersion: global.typesafeSbtPluginVersion
    });
  });

  it('creates files', () => {
    assert.file(['test/build.sbt']);
  });
});
