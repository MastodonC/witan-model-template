# witan-model

A Leiningen template to create models for our city modelling platform, [Witan](http://www.mastodonc.com/products/witan/).

The project has all the dependencies and structure to be run using the [workspace-executor](https://github.com/MastodonC/witan.workspace-executor/).

The strucure looks like this for a project named `foo`:
```Bash
├── project.clj
├── README.md
├── src
│   └── foo
│       ├── core.clj
│       ├── model.clj
│       └── schemas.clj
└── test
    └── foo
        ├── acceptance
        │   └── workspace_test.clj
        ├── core_test.clj
        ├── model_test.clj
        └── test_utils.clj
```
## Usage

To use locally:

1) Clone this repository
2) `$ cd witan-model-template`
3) `$ lein install`
4) Edit your `~/.lein/profiles.clj`:
Inside `:plugins` add `[witan-model/lein-template "0.1.0-SNAPSHOT"]`
5) In the directory where you want to create your witan model:
`$ lein new witan-model <your model name>`

## License

Copyright © 2017 Mastodon C Ltd

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
