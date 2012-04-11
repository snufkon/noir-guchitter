(ns noir-guchitter.models.migration
  (:use [noir-guchitter.models.db :only [my-db]])
  (require [clojure.java.jdbc :as sql]))

(defn create-guchi []
  (sql/with-connection my-db
    (sql/create-table :guchi
                      [:id :serial "PRIMARY KEY"]
      [:body :varchar "NOT NULL"]
      [:created_at :timestamp "NOT NULL" "DEFAULT CURRENT_TIMESTAMP"])))

(defn -main []
  (print "Migrating database...") (flush)
  (create-guchi)
  (println " done"))
