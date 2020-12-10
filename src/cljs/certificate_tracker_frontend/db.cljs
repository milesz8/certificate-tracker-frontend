(ns certificate-tracker-frontend.db)

(def default-db
  {:name "re-frame"
   :homes (list 
           {:id 1 :last "mclenon" } {:id 2 :last "ator"} {:id 3 :last "huggins"})})

(def user-key "current-user")

(defn set-user-ls
  [user]
  (.setItem js/localStorage user-key (str user)))

(defn remove-user-ls
  []
  (.removeItem js/localStorage user-key))