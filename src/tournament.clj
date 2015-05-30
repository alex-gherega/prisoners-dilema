(ns ^{:author "av. alex.gherega" :doc "The tournament arena"} tournament
    (:require [history :as his]
              [strategies :as sss]
              [refry :as judge]))

(defn gen-prisoner [name strategy]
  {:name name
   :history (his/start name)
   :strategy strategy})

(defn sel-strategy [p]
  (:strategy p))

(defn update-prisoner [prisoner choice]
  (assoc prisoner :history (his/update (:name prisoner)
                                       (:history prisoner)
                                       choice)))

(defn interogate [p1 p2 & ps]
  (let [apply-strategy-fn #((:strategy %1) (:hisytory %1) (:history %2))

        p1-res (apply-strategy-fn p1 p2)
        p2-res (apply-strategy-fn p2 p1)]
    (vec (map update-prisoner [p1 p2] [p1-res p2-res]))))

(defn run [n]
  (loop [[p1 p2] [(gen-prisoner :alex sss/random)
                  (gen-prisoner :cata sss/random)]
         n n]
    (if (zero? n)
      (judge/release-prisoner (into (:history p1) (:history p2)))
      (recur (interogate p1 p2) (dec n)))))
