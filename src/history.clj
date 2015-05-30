(ns ^{:author "av. alex gherega" :doc "API for handling history - a
map o f players and their past moves"} history)

(defn start [player & players]
  (into {player []}
        (map #(assoc {} % []) players)))

(defn is-overflow? [player h n]
  (not (< (-> h player count) n)))

(defn geth [player h n]
  (let [hv (h player)]
    (if (is-overflow? player h n)
      (subvec hv 1 n)
      hv)))

(defn update
  ([player h move n]
   (assoc h
          player
          (conj (geth player h n)
                move)))

  ([player h move]
   (assoc h player (conj (h player) move))))
