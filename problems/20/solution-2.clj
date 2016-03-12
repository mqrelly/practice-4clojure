(defn penultimate [s]
  (->> s
       (reverse)
       (rest)
       (first)))
