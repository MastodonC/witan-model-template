(ns ^{:doc "Defines the structure of the model for it
            to be run by a 'workspace-executor'"}
    {{name}}.model
    (:require [witan.workspace-api :refer [defmodel]]
              [witan.workspace-api.protocols :as p]
              [witan.workspace-api.utils :refer [map-fn-meta
                                                 map-model-meta]]
              [{{name}}.core :as c]))

(defmodel {{name}}
  "Defines the household model. Contains metadata,
   and the model workflow + catalog."
  {:witan/name :model/{{name}}
   :witan/version "1.0.0"}
  {:workflow model-workflow
   :catalog model-catalog})
