(ns leiningen.new.witan-model
  (:require [leiningen.new.templates :refer [renderer sanitize year ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "witan_model"))

(defn witan-model
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (sanitize name)
              :placeholder "{{sanitized}}"
              :year (year)}]
    (main/info "Generating fresh 'lein new' witan-model project.")
    (->files data
             [".gitignore"  (render "gitignore" data)]
             ["README.md"   (render "README.md" data)]
             ["project.clj" (render "project.clj" data)]
             ["src/{{sanitized}}/core.clj" (render "core.clj" data)]
             ["src/{{sanitized}}/model.clj" (render "model.clj" data)]
             ["src/{{sanitized}}/schemas.clj" (render "schemas.clj" data)]
             ["test/{{sanitized}}/test_utils.clj" (render "test_utils.clj" data)]
             ["test/{{sanitized}}/core_test.clj" (render "core_test.clj" data)]
             ["test/{{sanitized}}/model_test.clj" (render "model_test.clj" data)]
             ["test/{{sanitized}}/acceptance/workspace_test.clj" (render "workspace_test.clj" data)]
             )))
