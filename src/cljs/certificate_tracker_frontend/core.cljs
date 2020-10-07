(ns certificate-tracker-frontend.core
  (:require
   [reagent.dom :as rdom]
   [re-frame.core :as re-frame]
   [re-pressed.core :as rp]
   [certificate-tracker-frontend.events :as events]
   [certificate-tracker-frontend.routes :as routes]
   [certificate-tracker-frontend.views :as views]
   [certificate-tracker-frontend.config :as config]
   ))


(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root []
  (re-frame/clear-subscription-cache!)
  (let [root-el (.getElementById js/document "app")]
    (rdom/unmount-component-at-node root-el)
    (rdom/render [views/main-panel] root-el)))

(defn init []
  (routes/app-routes)
  (re-frame/dispatch-sync [::events/initialize-db])
  (re-frame/dispatch-sync [::rp/add-keyboard-event-listener "keydown"])
  (dev-setup)
  (mount-root))