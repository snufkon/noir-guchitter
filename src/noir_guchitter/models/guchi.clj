(ns noir-guchitter.models.guchi
  (:use [noir-guchitter.models.db :only [my-db]])
  (:require [clojure.java.jdbc :as sql]))

(defn get-all []
  (sql/with-connection my-db
    (sql/with-query-results results
      ["select * from guchi order by id desc"]
      (vec results))))

(defn create [guchi]
  (sql/with-connection my-db
    (sql/insert-values :guchi [:body] [guchi])))
