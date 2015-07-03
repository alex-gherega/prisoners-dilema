(ns ^{:author "av. alex gherega" :doc "Checking for a winner"} partial-solution.refry
    (:require [history :as h]))

(defn make-score-system [cooperate defect]
  ;; a map representing the scoring system
  {[cooperate cooperate] [3 3]
   [cooperate defect] [0 5]
   [defect cooperate] [5 0]
   [defect defect] [1 1]})

(def default-ss (make-score-system :C :D)) ;; default symbols

(defn score [choice-p1 choice-p2]
  ;; select the scoring based on the prisoners choices
  (default-ss [choice-p1 choice-p2]))

(defn call-winner [prisoner-1 prisoner-2 & _]
  ;; determine who's the winner or announce a :tie
  )

(defn- build-result [prisoners choices]
  ;;TODO: change this lazy sequence to something else if needed
  ;; given a set o prisoners and their moves make a collection of map-entries/vectors of the form
  ;; [prisoner choice]
  (map #(first (assoc {} %1 %2)) prisoners choices))

(defn release-prisoner [full-history];;
  ;; compute the full score for each prisoner
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
