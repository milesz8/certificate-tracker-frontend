(ns certificate-tracker-frontend.views.families
  (:require
   [re-frame.core :as re-frame]
   [re-com.core :as re-com]
   [certificate-tracker-frontend.subs :as subs]))

(defn families-title []
  [re-com/title
   :label (str "Hellow, this is the families Page!")
   :level :level1])

(defn link-to-login-page []
  [re-com/hyperlink-href
   :label "go to login page"
   :href "#/login"])

(defn families-page []
  [re-com/v-box
   :gap "1em"
   :children [[families-title]
              [link-to-login-page]]])
