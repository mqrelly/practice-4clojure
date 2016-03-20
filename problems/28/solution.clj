(defn flattener [s]
  (reduce 
    (fn [acc e] 
      (if (sequential? e)
        (into acc (flattener e))
        (conj acc e)))
    []
    s))
