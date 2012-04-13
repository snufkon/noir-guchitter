(ns noir-guchitter.views.guchi
  (:require [noir-guchitter.views.common :as common]
            [clojure.string :as string]
            [ring.util.response :as ring]
            [noir-guchitter.models.guchi :as model])
  (:use [noir.core :only [defpage]]
        [hiccup.core :only [html h]]
        [hiccup.page-helpers :only [doctype]]
        [hiccup.form-helpers :only [form-to label text-area submit-button]]))

(defn guchi-form []
  [:div {:id "guchi-form" :class "hero-unit"}
   [:form {:method "POST" :action "/"}
    (label "guchi" "愚痴ってもいいんだよ？")
    [:textarea {:name "guchi" :id "guchi" :class "span8" :rows "4"}]
    [:input {:class "btn btn-primary btn-large btn-guchiru" :type "submit" :value "ぐちる"}]]])

(defn display-guchi [guchis]
  [:div {:id "guchi"}
   (map
    (fn [guchi] [:h2 {:class "guchi-unit"} (h (:body guchi))])
    guchis)])

(defn create [params]
  (let [guchi (:guchi params)]
    (when-not (string/blank? guchi)
      (model/create guchi)))
  (ring/redirect "/"))


(defpage "/" []
  (common/layout "ぐちってー"
                 (guchi-form)
                 (display-guchi (model/get-all))))

(defpage [:post "/"] {:as params}
  (create params))
