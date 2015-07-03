(ns ^{:author "av. alex.gherega" :doc "The tournament arena"} partial-solution.tournament
    (:require [history :as his]
              [strategies :as sss]
              [refry :as judge]))

(defn gen-prisoner [name strategy]
  ;; create a map holding keys :name :history and :strategy defining a prisoner
  {:name name
   :history (his/start name)
   :strategy strategy})

(defn sel-strategy [p]
  ;; given a prisoner select it's strategy
  )

(defn update-prisoner [prisoner choice]
  ;; after a prisoner has it's choice update it's history
  )

(defn interogate [p1 p2 & ps]
  ;; return a vector of updated-prisoners after applying theyr strategies when interogated
  )

(defn run [n]
  ;; iterate the game for n times
  )
