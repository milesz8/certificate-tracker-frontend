(ns certificate-tracker-frontend.db)

(def default-db
  {:name "re-frame"})

(def user-key "current-user")

(defn set-user-ls
  [user]
  (.setItem js/localStorage user-key (str user)))

(defn remove-user-ls
  []
  (.removeItem js/localStorage user-key))