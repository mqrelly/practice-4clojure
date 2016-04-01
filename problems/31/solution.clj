(fn [s]
  (let [
        [packed last-list]
        (reduce
          (fn [[packed last-list] e]
            (if (= (first last-list) e)
              [packed (conj last-list e)]
              [(conj packed last-list) [e]]))
          [[] [(first s)]]
          (rest s))]
    (conj packed last-list)))
