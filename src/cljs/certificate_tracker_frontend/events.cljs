(ns certificate-tracker-frontend.events
  (:require
   [re-frame.core :as re-frame]
   [certificate-tracker-frontend.db :as db]
   [certificate-tracker-frontend.routes :as router]
   ))

(defn initialize-db
  [_ _]
  db/default-db)

(defn set-active-page
  [db [_ {:keys [page]}]]
  (assoc db :active-page page))

(defn checkUser
  [credentials]
  (= credentials
     {:username "miles@gmail.com"
      :password "password"}))

(defn login
  [{:keys [db]} [_ credentials]]
  (if (checkUser credentials) 
  {:set-url {:url "/familes"}}))



(def log (.-log js/console))

(defn set-url
  [{:keys [url]}]
  (router/set-token! url))

(re-frame/reg-event-db :initialize-db initialize-db)
(re-frame/reg-event-db :set-active-page set-active-page)
(re-frame/reg-fx :set-url set-url)
(re-frame/reg-event-fx :login login)