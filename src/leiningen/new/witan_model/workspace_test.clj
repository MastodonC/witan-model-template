(ns {{name}}.acceptance.workspace-test
    (:require [clojure.test :refer :all]
              [schema.core :as s]
              [{{name}}.schemas :as sc]
              [{{name}}.core :refer :all]
              [{{name}}.model :as m]
              [witan.workspace-api.protocols :as p]
              [witan.workspace-executor.core :as wex]
              [clojure.core.matrix.dataset :as ds]
              [witan.datasets :as wds]
              [witan.models.test-utils :as tu]))

;; Example of inputs
(def test-inputs
  {:dataset-1 ["path/to/dataset1.csv" sc/DataSet1]
   :dataset-2 ["path/to/dataset2.csv" sc/DataSet2]})

(defn add-input-params
  [input]
  (assoc-in input [:witan/params :fn] (partial tu/read-inputs test-inputs input)))

(deftest model-workspace-test
  (testing "The default model is run on the workspace and returns the outputs expected"
    (let [fixed-catalog (mapv #(if (= (:witan/type %) :input) (add-input-params %) %)
                              (:catalog m/send-model))
          workspace     {:workflow  (:workflow m/send-model)
                         :catalog   fixed-catalog
                         :contracts (p/available-fns (m/model-library))}
          workspace'    (s/with-fn-validation (wex/build! workspace))
          result        (apply merge (wex/run!! workspace' {}))]
      (is result)
      ;; Replace 'test-model-outputs' by a test
      ;; to check the expected keys are present in the result map
      test-model-outputs
      )))
