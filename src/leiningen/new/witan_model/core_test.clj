(ns {{name}}.core-test
  (:require [clojure.test :refer :all]
            [{{name}}.core :refer :all]
            [{{name}}.schemas :as sc]
            [{{name}}.test-utils :as tu]
            [clojure.core.matrix.dataset :as ds]
            [witan.datasets :as wds]
            [clojure.java.io :as io]))


;; Example of inputs
(def test-inputs
  {:dataset-1 ["path/to/dataset1.csv" sc/DataSet1]
   :dataset-2 ["path/to/dataset2.csv" sc/DataSet2]})

(defn prep-inputs [inputs-map]
  (reduce merge
          (map (fn [[name [filepath schema]]]
                 {name (tu/csv-to-dataset filepath schema)})
               inputs-map)))

;; Tests for functions defined in core.clj
