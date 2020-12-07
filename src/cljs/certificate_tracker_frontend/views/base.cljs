(ns certificate-tracker-frontend.views.base
  (:require
   [certificate-tracker-frontend.routes]
   [certificate-tracker-frontend.subs]
   [certificate-tracker-frontend.views.families :as families]
   [certificate-tracker-frontend.views.auth :as auth]
   [re-frame.core :as re-frame]))

(defn home []
  [:div
   "home"])

(defn not-found
  []
  [:div.container
   [:h1 "404"]
   [:h3 "Mislabeled."]])

(defn pages [page-name]
  (case page-name
    :login            [auth/login-page]
    :familes            [families/families-page]
    [not-found]))

(defn certificate-tracker-frontend
  []
  (let [active-page @(re-frame/subscribe [:active-page])]
    [:div
     [:div.content [pages active-page]]]))