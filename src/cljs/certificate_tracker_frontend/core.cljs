(ns certificate-tracker-frontend.core
  (:require
   [certificate-tracker-frontend.events]
   [certificate-tracker-frontend.routes :as router]
   [certificate-tracker-frontend.views.base :as views]
   [re-frame.core :as re-frame]
   [reagent.dom :as rdom]))

(defn ^:dev/after-load mount-root []
  (re-frame/clear-subscription-cache!)
  (let [root-el (.getElementById js/document "app")]
    (rdom/unmount-component-at-node root-el)
    (rdom/render [views/certificate-tracker-frontend] root-el)))

(defn ^:export init
  []
  (router/start!)
  (re-frame/dispatch-sync [:initialize-db])
  (rdom/render [views/certificate-tracker-frontend]
               (.getElementById js/document "app")))