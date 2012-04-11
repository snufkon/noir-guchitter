(ns noir-guchitter.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-css html5]]))

(defpartial layout [title & content]
  (html5
   [:head
    [:meta {:charset "utf-8"}]
    [:title "noir-guchitter"]
    (include-css "/css/reset.css"
                 "/css/bootstrap.css"
                 "/css/guchi.css")]
   [:body
    [:div {:class "container"}
     [:div {:id "header" :class "page-header"}
      [:h1 title]]
     [:div {:id "content"} content]]]))
