(ns certificate-tracker-frontend.views.login
  (:require
   [re-frame.core :as re-frame]
   [re-com.core :as re-com]
   [certificate-tracker-frontend.subs :as subs]))

(defn login-title []
  [re-com/title
   :label "Hello, this is the login Page!"
   :level :level1])

(defn link-to-families-page []
  [re-com/hyperlink-href
   :label "go to families Page"
   :href "#/"])

(defn login-page []
  [re-com/v-box
   :gap "1em"
   :children [[login-title]
              [link-to-families-page]]])