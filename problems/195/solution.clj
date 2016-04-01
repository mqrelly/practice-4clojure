(defn all-paren-patterns [n]
  (let [is-valid-prefix? (fn [ptn] (<= (apply + ptn) (count ptn)))
        is-valid? (fn [ptn] (= (apply + ptn) (count ptn)))
        to-str (fn [ptn]
                 (->>
                   ptn
                   (map #(cons \( (repeat % \))))
                   (flatten)
                   (apply str)))]

    (loop [work-set '([])
           result-set '()]
      (let [pattern (first work-set)
            length (count pattern)
            length+1 (inc length)]
        (if (some? pattern)
          (if (= length n)
            (recur (rest work-set)
                   (if (is-valid? pattern) 
                     (conj result-set pattern)
                     result-set))
            (recur
              (into (rest work-set)
                    (->>
                      (for [i (range (inc length+1))] (conj pattern i))
                      (filter is-valid-prefix?)))
              result-set))
          (map to-str result-set))))))
