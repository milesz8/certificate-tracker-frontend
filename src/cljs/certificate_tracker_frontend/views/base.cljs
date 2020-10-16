(ns certificate-tracker-frontend.views.base
  (:require
   [re-frame.core :as re-frame]
   [re-com.core :as re-com]
   [certificate-tracker-frontend.subs :as subs]
   [certificate-tracker-frontend.views.login :as login]
   [certificate-tracker-frontend.views.families :as families]))

(defn- pages [page-name]
  (case page-name
    :families-page [families/families-page]
    :login-page [login/login-page]
    [:div]))

(defn show-page [page-name]
  [pages page-name])

(defn base-page []
  (let [active-page (re-frame/subscribe [::subs/active-page])]
    [re-com/v-box
     :height "100%"
     :children [[pages @active-page]]]))