(ns certificate-tracker-frontend.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :name
 (fn [db]
   (:name db)))

(re-frame/reg-sub
 :active-page
 (fn [db _]
   (:active-page db)))

(re-frame/reg-sub
 :errors
 (fn [db _]
   (:errors db)))

(re-frame/reg-sub
 :loading
 (fn [db _]
   (:loading db)))