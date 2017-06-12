(ns ^{:doc "Defines the calculations for each step of the model.
            The functions are defined using macros that make it easy to
            be packaged into a datastructure to be run by a 'workspace-executor'"}
    {{name}}.core
    (:require [witan.workspace-api :refer [defworkflowfn
                                           definput
                                           defworkflowpred
                                           defworkflowoutput]]
              [{{name}}.schemas :as sc]
              [clojure.core.matrix.dataset :as ds]
              [witan.datasets :as wds]))
