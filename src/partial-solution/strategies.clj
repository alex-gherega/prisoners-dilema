(ns ^{:author "av alex.gherega" :doc "strategy holder ns"} partial-solution.strategies)

(defn random
  ;; randomly select one of the symbols
  ([_ _ symbols]
   ((vec symbols) (-> symbols count rand-int)))
  ;; randomly select between :C and :D
  ([_ _]
   (random nil nil [:C :D])))
