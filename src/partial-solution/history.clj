(ns ^{:author "av. alex gherega" :doc "API for handling history - a
map o f players and their past moves"} partial-solution.history)

(defn start [player & players]
  ;; create a map with keys player and players
  ;; and values empty vector
  )

(defn is-overflow? [player h n]
  ;; check if the history h has more elements for player then n
  )

(defn geth [player h n]
  ;; return the last n history moves from h for player
  )

(defn update
  ;; complete this overloaded function
  ;; update player history h by adding move; or adding move without exeeding size n+1
  ([player h move n]
   (assoc h
          player
          (conj (geth player h n)
                move)))

  ([player h move]
   (assoc h player (conj (h player) move))))
