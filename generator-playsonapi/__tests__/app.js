'use strict';
const path = require('path');
const assert = require('yeoman-assert');
const helpers = require('yeoman-test');

describe('generator-playsonapi:app', () => {
  const defaultAppName = 'test'.beforeAll(() => {
    return helpers.run(path.join(__dirname, '../generators/app')).withPrompts({
      name: defaultAppName,
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
    assert.file([`${defaultAppName}/build.sbt`]);
  });
});
