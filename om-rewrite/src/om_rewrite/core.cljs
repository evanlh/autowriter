(ns om-rewrite.core
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(enable-console-print!)

(def app-state
  (atom
   {:text "Type in me"
    :typing-cursor 0,
    :backspace-cursor 0
    }))

(om/root
  (fn [app owner]
    (reify om/IRender
      (render [_]
        (dom/div nil
         (dom/p nil (:text app))))))
  app-state
  {:target (. js/document (getElementById "app"))})
