(defn my-nth [s n]
  "Returns the n-th element of the given sequence s or nil if the element
   isn't in the sequence."
  (loop [e (first s)
         r (rest s)
         i 0]
    (if (= i n)
      e
      (if (seq r)
        (recur (first r)
               (rest r)
               (inc i))))))
