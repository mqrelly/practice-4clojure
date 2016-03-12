(defn my-last [s]
  (reduce (fn [acc e] e) s))
