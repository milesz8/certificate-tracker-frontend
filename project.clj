(defproject certificate-tracker-frontend "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.773"
                  :exclusions [com.google.javascript/closure-compiler-unshaded
                               org.clojure/google-closure-library
                               org.clojure/google-closure-library-third-party]]
                 [thheller/shadow-cljs "2.10.17"]
                 [reagent "0.10.0"]
                 [re-frame "1.0.0"]
                 [cljs-ajax "0.7.3"]
                 [kibu/pushy "0.3.8"]
                 [day8.re-frame/http-fx "v0.2.0"]
                 [re-com "2.9.0"]
                 [bidi "2.1.5"]
                 [re-graph "0.1.13"]
                 [reagent-data-table "2.2.2"]
                 [district0x/graphql-query "1.0.6"]]

  :plugins [[lein-shadow "0.3.1"]
            [lein-less "1.7.5"]
            [lein-shell "0.5.0"]]

  :min-lein-version "2.9.0"

  :source-paths ["src/clj" "src/cljs"]

  :test-paths   ["test/cljs"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"
                                    "test/js"]


  :less {:source-paths ["less"]
         :target-path  "resources/public/css"}
  :shell {:commands {"open" {:windows ["cmd" "/c" "start"]
                             :macosx  "open"
                             :linux   "xdg-open"}}}
  :shadow-cljs {:nrepl {:port 8777}
                :builds {:app {:target :browser
                               :output-dir "resources/public/js/compiled"
                               :asset-path "/js/compiled"
                               :modules {:app {:init-fn certificate-tracker-frontend.core/init
                                               :preloads [devtools.preload
                                                          day8.re-frame-10x.preload]}}
                               :devtools {:http-root "resources/public"
                                          :http-port 8280}}
                         :karma-test {:target :karma
                                      :ns-regexp "-test$"
                                      :output-to "target/karma-test.js"}}}
  :aliases {"dev"          ["with-profile" "dev" "do"
                            ["shadow" "watch" "app"]]
            "prod"         ["with-profile" "prod" "do"
                            ["shadow" "release" "app"]]
            "build-report" ["with-profile" "prod" "do"
                            ["shadow" "run" "shadow.cljs.build-report" "app" "target/build-report.html"]
                            ["shell" "open" "target/build-report.html"]]
            "karma"        ["with-profile" "dev" "do"
                            ["shadow" "compile" "karma-test"]
                            ["shell" "karma" "start" "--single-run" "--reporters" "junit,dots"]]}

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "1.0.2"]
                   [day8.re-frame/test "0.1.5"]
                   [day8.re-frame/re-frame-10x "0.7.0"]]
    :source-paths ["dev"]
    :shadow-cljs {:builds {:app {:closure-defines {"re_frame.trace.trace_enabled_QMARK_" true}}}}}

   :prod {}}

  :prep-tasks [["less" "once"]])
