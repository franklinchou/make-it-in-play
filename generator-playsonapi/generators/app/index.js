'use strict';
const Generator = require('yeoman-generator');
const chalk = require('chalk');
const yosay = require('yosay');
// const Helper = require('yo-java-helper');

module.exports = class extends Generator {
  prompting() {
    // Have Yeoman greet the user.
    this.log(
      yosay(`Welcome to the tremendous ${chalk.red('generator-playsonapi')} generator!`)
    );

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
        default: `com.${this.user.github.username}`  // TODO Why you no work?
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
        default: '1.1.6'
      },
      {
        type: 'input',
        name: 'scalaVersion',
        message: 'scala version',
        default: '2.12.17'
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
        scala: this.props.scalaVersion
      }
    );
  }

  // install() {
  //   this.installDependencies();
  // }
};
