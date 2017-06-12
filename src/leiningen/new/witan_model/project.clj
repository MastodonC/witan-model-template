(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [net.mikera/core.matrix "0.60.3"]
                 [witan.workspace-api "0.1.23"]
                 [prismatic/schema "1.1.6"]
                 [org.clojure/data.csv "0.1.4"]]
  :profiles {:dev {:dependencies [[witan.workspace-executor "0.2.7"
                                   :exclusions [witan.workspace-api]]
                                  [environ "1.1.0"]]}})
