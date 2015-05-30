(ns ^{:author "av alex.gherega" :doc "strategy holder ns"} strategies)

(defn random
  ([_ _ symbols]
   ((vec symbols) (-> symbols count rand-int)))
  ([_ _]
   (random nil nil [:C :D])))
