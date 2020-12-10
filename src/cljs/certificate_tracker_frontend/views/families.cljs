(ns certificate-tracker-frontend.views.families
  (:require
   [re-frame.core :as re-frame]
   [re-com.core :as re-com]
   [reagent.core :as reagent]
   [certificate-tracker-frontend.subs :as subs]))

(defn families-title []
  [re-com/title
   :label (str "Hello, this is the families Page!")
   :level :level1])

(defn families-list []
  (let [selections (reagent/atom (set '(1)))
        list (reagent/atom [{:id 1 :label "mclenon"} {:id 2 :label "miles"}])]
   [re-com/selection-list
    :choices list
    :model selections
    :multi-select? false
    :on-change #(reset! selections %)]))

(defn families-page []
  [re-com/v-box
   :gap "1em"
   :children [[families-title]
              [families-list]]])
