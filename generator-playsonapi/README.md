# generator-playsonapi
> An opinionated framework for writing play web-services with jsonapi.

## Installation

First, install [Yeoman](http://yeoman.io) and generator-playsonapi using [npm](https://www.npmjs.com/) (we assume you have pre-installed [node.js](https://nodejs.org/)).

```bash
npm install -g yo
```

To install generator-playsonapi global
```bash
npm install -g generator-playsonapi
```

If you can't or don't want a global install then install the generator only for the current user
```bash
cd make-it-in-play/generator-playsonapi
yarn link
```

Then generate your new project:

```bash
yo playsonapi
```

Note that generator-playsonapi will prompt you for information about version numbers
for various sbt packages. This is for _setting_ those versions only. Actual package
installation and setup will be done by sbt by issuing `sbt clean compile` from your
project directory after yeoman has created your shiny new application.


## Tests

From this directory issue: `npm test`


## Getting To Know Yeoman

 * Yeoman has a heart of gold.
 * Yeoman is a person with feelings and opinions, but is very easy to work with.
 * Yeoman can be too opinionated at times but is easily convinced not to be.
 * Feel free to [learn more about Yeoman](http://yeoman.io/).

## License

MIT © [Franklin Chou]()


[npm-image]: https://badge.fury.io/js/generator-playsonapi.svg
[npm-url]: https://npmjs.org/package/generator-playsonapi
[travis-image]: https://travis-ci.org/franklinchou/generator-playsonapi.svg?branch=master
[travis-url]: https://travis-ci.org/franklinchou/generator-playsonapi
[daviddm-image]: https://david-dm.org/franklinchou/generator-playsonapi.svg?theme=shields.io
[daviddm-url]: https://david-dm.org/franklinchou/generator-playsonapi
