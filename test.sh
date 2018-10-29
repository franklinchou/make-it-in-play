#!/usr/bin/env bash

set -o errexit          # Exit on most errors (see the manual)
set -o errtrace         # Make sure any error trap is inherited
set -o nounset          # Disallow expansion of unset variables
set -o pipefail         # Use last non-zero exit code in a pipeline

trap cleanup $?         # Trap clean up on any exit code

function main() {
    echo $(whoami)
    echo Running automated integration test...
    cd generator-playsonapi
    npm link
    npm install -g yo
    cd $PROJECT_ROOT
    mkdir -p $TEST_PROJECT_NAME
    cd $TEST_PROJECT_NAME
    yo playsonapi --headless
    echo Test scaffolding complete. Running sbt tests...
    cd $TEST_PROJECT_NAME
    sbt clean compile
    sbt test
}

function cleanup() {
    echo Cleaning up...
    cd $PROJECT_ROOT
    rm -r test/
    echo Done.
}

PROJECT_ROOT=$(pwd)
TEST_PROJECT_NAME=test
main
echo Test script exited with code $?