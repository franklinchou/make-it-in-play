'use strict';
const Generator = require('yeoman-generator');
const chalk = require('chalk');
const yosay = require('yosay');
const global = require('./global');

module.exports = class extends Generator {
  prompting() {
    // Have Yeoman greet the user.
    this.log(yosay(`Welcome to the ${chalk.red('generator-playsonapi')} generator!`));

    this.log(`Scala version: ${global.scalaBaseVersion}`);

    const prompts = [
      {
        type: 'input',
        name: 'name',
        message: 'Project name (name the root level package of this application)',
        default: this.appname
      },
      {
        type: 'input',
        name: 'organization',
        message: 'Organization name',
        default: `com.${this.user.github.username}` // TODO Why you no work?
      },
      {
        type: 'input',
        name: 'projectVersion',
        message: 'Project version',
        default: '0.0.1'
      },
      {
        type: 'input',
        name: 'sbtVersion',
        message: 'sbt version',
        default: global.sbtVersion
      },
      {
        type: 'input',
        name: 'playJsonExtensionsVersion',
        message: 'ai.x => play-json-extensions version',
        default: global.playJsonExtensionsVersion
      },
      {
        type: 'input',
        name: 'scalaTestVersion',
        message: `org.scalatest => scalatest_2.12 version (scala ${
          global.scalaBaseVersion
        })`,
        default: global.scalaTestVersion
      },
      {
        type: 'input',
        name: 'scalaTestPlusPlayVersion',
        message: 'org.scalatestplus.play => scalatestplus-play version',
        default: global.scalaTestPlusPlayVersion
      },
      {
        type: 'input',
        name: 'typesafeSbtPluginVersion',
        message: 'com.typesafe.play => sbt-plugin version',
        default: global.typesafeSbtPluginVersion
      }
    ];

    return this.prompt(prompts).then(props => {
      // To access props later use this.props.someAnswer;
      this.props = props;
    });
  }

  writing() {
    this.fs.copyTpl(
      this.templatePath('project-root/build.sbt'),
      this.destinationPath(`${this.props.name}/build.sbt`),
      {
        appname: this.props.name,
        organization: this.props.organization,
        version: this.props.projectVersion,
        scalaVersion: global.scalaVersion,
        playJsonExtensionsVersion: this.props.playJsonExtensionsVersion,
        scalaTestVersion: this.props.scalaTestVersion,
        scalaTestPlusPlayVersion: this.props.scalaTestPlusPlayVersion
      }
    );
    this.fs.copyTpl(
      this.templatePath('project-root/project/build.properties'),
      this.destinationPath(`${this.props.name}/project/build.properties`),
      {
        sbtVersion: this.props.sbtVersion
      }
    );
    this.fs.copyTpl(
      this.templatePath('project-root/project/plugins.sbt'),
      this.destinationPath(`${this.props.name}/project/plugins.sbt`),
      {
        typesafeSbtPluginVersion: this.props.typesafeSbtPluginVersion
      }
    );
    this.fs.copy(
      this.templatePath('project-root/app/controllers'),
      this.destinationPath(`${this.props.name}/app/controllers`)
    );
    this.fs.copy(
      this.templatePath('project-root/app/lib'),
      this.destinationPath(`${this.props.name}/app/lib`)
    );
    // This.fs.copy(
    //   this.templatePath('project-root/app/models'),
    //   this.destinationPath(`${this.props.name}/app/models`)
    // );
    // this.fs.copy(
    //   this.templatePath('project-root/app/resources'),
    //   this.destinationPath(`${this.props.name}/app/resources`)
    // );
  }

  // Install() {
  //   this.installDependencies();
  // }
};
