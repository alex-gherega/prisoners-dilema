(ns ^{:author "av. alex gherega" :doc "Checking for a winner"} refry
    (:require [history :as h]))

(defn make-score-system [cooperate defect]
  {[cooperate cooperate] [3 3]
   [cooperate defect] [0 5]
   [defect cooperate] [5 0]
   [defect defect] [1 1]})

(def default-ss (make-score-system :C :D))

(defn score [choice-p1 choice-p2]
  (default-ss [choice-p1 choice-p2]))

(defn call-winner [prisoner-1 prisoner-2 & _]
  (let [[s1 s2] (score (val prisoner-1)
                       (val prisoner-2))]
    (cond (> s1 s2) (key prisoner-1)
          (< s1 s2) (key prisoner-2)
          :else :tie)))

(defn- build-result [prisoners choices]
  ;;TODO: change this lazy sequence to something else if needed
  (map #(first (assoc {} %1 %2)) prisoners choices))

(defn release-prisoner [full-history]
  (let [prisoners (-> full-history keys vec)
        choices (->> full-history
                     vals
                     vec
                     (apply map vector)
                     (map (partial build-result prisoners)))
        results (map #(apply call-winner %)
                     choices)]

    (map #(assoc {} %
                 (count (filter (fn [pl] (= % pl)) results))) prisoners)))
