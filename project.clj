(defproject tic-tac-toe "0.1.0-SNAPSHOT"
  :description "Good ol' Tic-Tac-Toe, a favourite of mine that I try and implement all the time to test my understanding of new concepts"
  ;:url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]]
  :main ^:skip-aot tic-tac-toe.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
