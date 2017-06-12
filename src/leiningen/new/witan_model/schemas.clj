(ns ^{:doc "Defines the schemas for the inputs/outputs of functions in core.clj."}
    {{name}}.schemas
    (require [schema.core :as s]))

;; Generate schemas for core.matrix datasets
(defn make-ordered-ds-schema
  [col-vec]
  {:column-names (mapv #(s/one (s/eq (first %)) (str (first %))) col-vec)
   :columns (mapv #(s/one [(second %)] (format "col %s" (name (first %)))) col-vec)
   s/Keyword s/Any})

(defn make-row-schema
  [col-schema]
  (mapv (fn [s] (let [datatype (-> s :schema first)
                      fieldname (:name s)]
                  (s/one datatype fieldname)))
        (:columns col-schema)))

(defn make-col-names-schema
  [col-schema]
  (mapv (fn [s] (let [datatype (:schema s)
                      fieldname (:name s)]
                  (s/one datatype fieldname)))
        (:column-names col-schema)))

;; Define schemas for functions inputs/outputs
;; Examples of schemas
(def DataSet1
  (make-ordered-ds-schema [[:col-1 s/Str] {:col-2 s/Int}]))

(def DataSet2
  (make-ordered-ds-schema [[:col-1 s/Str] {:col-2 s/Keyword}]))
