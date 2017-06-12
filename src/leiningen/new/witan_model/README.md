# {{name}}

## Table of content

* [Features](#features)
* [Contribute](#contribute)
  * [Coding guidelines](#coding-guidelines)
  * [Development tools](#development-tools)
* [Usage](#usage)
* [License](#license)

## Features

## Contribute

### Coding guidelines

### Development tools
#### To visualise a model workflow, you need to:

1) Install `Graphviz`:

- Ubuntu: `$ sudo apt-get install graphviz`

- MacOS: `$ brew install graphviz`

For any OS you should also be able to install it with "pip": `$ pip install graphviz`.

2) Use the `view-workflow` function for a model workflow `my-model-workflow`
as follows:

```Clojure
(witan.workspace-executor.core/view-workflow my-model-workflow)
```
#### To print logs, use the `set-api-logging!` function:

```Clojure
(witan.workspace-api/set-api-logging! println)
```
Whenever a `defworkflowfn` is called logs will be written to your repl or terminal. It's very  useful for debugging purpose.

Turn it off with:
```Clojure
(witan.workspace-api/set-api-logging! identity)
```

## Usage

## License

Copyright © 2017

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
