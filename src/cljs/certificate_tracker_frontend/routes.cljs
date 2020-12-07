(ns certificate-tracker-frontend.routes
  (:require [bidi.bidi :as bidi]
            [pushy.core :as pushy]
            [re-frame.core :as re-frame]))

(def routes
  ["/" {"" :login
        "login"        :login
        "familes"      :familes}])


(def history
  (let [dispatch #(re-frame/dispatch [:set-active-page {:page (:handler %)}])
        match #(bidi/match-route routes %)]
    (pushy/pushy dispatch match)))

(defn start!
  []
  (pushy/start! history))

(def url-for (partial bidi/path-for routes))

(defn set-token!
  [token]
  (pushy/set-token! history token))
