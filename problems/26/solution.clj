(defn fibonacci [n]
  (loop [a 1 b 1
         i 0 
         acc []]
    (if (= i n)
      acc
      (recur b (+ a b)
             (inc i) (conj acc a)))))
