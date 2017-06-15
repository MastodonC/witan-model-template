# Witan-model template

## What's a Witan model?
We talk about "Witan model" for a model that can be run on our city modelling platform, [Witan](http://www.mastodonc.com/products/witan/).

Witan model are run using the [workspace-executor](https://github.com/MastodonC/witan.workspace-executor/), and need to be built using tools from the [workspace-api](https://github.com/MastodonC/witan.workspace-api).

Here are a few examples of Witan models:
* A population projection model, [witan.models.demography](https://github.com/mastodonc/witan.models.demography)
* A dwelling projections model, [witan.models.household](https://github.com/MastodonC/witan.models.household)
* A fire risk scores model, [witan.gwyn](https://github.com/MastodonC/witan.gwyn)
* A special educational needs and disability projections model, [witan.send](https://github.com/MastodonC/witan.send)

## What's in this template?
As with most Leiningen templates, it includes a [`README.md`](https://github.com/MastodonC/witan-model-template/blob/master/src/leiningen/new/witan_model/README.md), a [`project.clj`](https://github.com/MastodonC/witan-model-template/blob/master/src/leiningen/new/witan_model/project.clj) and a [`.gitignore`](https://github.com/MastodonC/witan-model-template/blob/master/src/leiningen/new/witan_model/gitignore).

This template will create the following files in the `src/` directory:
* [`core.clj`](https://github.com/MastodonC/witan-model-template/blob/master/src/leiningen/new/witan_model/core.clj)
This namespace expects functions to define the calculation for the model.
For a Witan model that means using the macros from the `workspace-api`:
	* `definput` for functions to get the model input datasets
	* `defworkflowfn` for functions performing data transformation or calculations
	* `defworkflowpred` for predicate functions, usually to exit a projection loop
	* `defworkflowoutput` for functions to get the model output datasets
* [`model.clj`](https://github.com/MastodonC/witan-model-template/blob/master/src/leiningen/new/witan_model/model.clj)
This namespace expects code to define the structure of the model. It also uses tools from the `workspace-api`:
	* `defmodel` to create a data structure with metatdata and data on the model. It contains both info on the model's steps (`:workflow`) and further info on each step (`:catalog`).
	* `model-library` to list available `defmodels` and available function for each model.
Note: When using the [`xml-to-model-structure`](https://github.com/MastodonC/xml-to-model-structure) tool to generate the model from a flowchart, the variable names `model-workflow`, `model-catalog` and `model-functions` get replaced by the actual workflow, catalog and list of functions (list of functions not yet implemented).
* [`schemas.clj`](https://github.com/MastodonC/witan-model-template/blob/master/src/leiningen/new/witan_model/schemas.clj)
This namespace expects schemas for the inputs and outputs of the calculation functions.
I have added helper functions and examples of what those schemas can look like.
And the following files in the `test` directory:
* [`acceptance/workspace_test.clj`](https://github.com/MastodonC/witan-model-template/blob/master/src/leiningen/new/witan_model/workspace_test.clj)
* [`core_test.clj`](https://github.com/MastodonC/witan-model-template/blob/master/src/leiningen/new/witan_model/core_test.clj)
* [`model_test.clj`](https://github.com/MastodonC/witan-model-template/blob/master/src/leiningen/new/witan_model/model_test.clj)
* [`test_utils.clj`](https://github.com/MastodonC/witan-model-template/blob/master/src/leiningen/new/witan_model/test_utils.clj)


**NOTE**
A project created by this template wouldn't be able to have its tests pass or even compile.
It needs bits to be filled. The aim of another project: [`xml-to-model-structure`](https://github.com/MastodonC/xml-to-model-structure), is to automate the completion of the project code to write a project structure (the code without the actua calculation) tailored to the specify of your model (by passing in a model flowchart saved as an xml file).
