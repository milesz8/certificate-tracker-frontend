(ns certificate-tracker-frontend.events
  (:require
   [re-frame.core :as re-frame]
   [certificate-tracker-frontend.db :as db]
   ))

(defn initialize-db
  [_ _]
  db/default-db)

(defn set-active-page
  [db [_ {:keys [page]}]]
  (assoc db :active-page page))

;; (defn mock-login
;;   [{:keys [db]} [_ _]]
;;   {:db         (assoc-in db [:loading :login] true)
;;    :set-url {:url "/task"}})

(def log (.-log js/console))

(re-frame/reg-event-db :initialize-db initialize-db)
(re-frame/reg-event-db :set-active-page set-active-page)
;; (re-frame/reg-event-fx ::mock-login mock-login)