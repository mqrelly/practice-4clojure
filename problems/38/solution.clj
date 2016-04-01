(defn my-max
  [& args]
  (reduce 
    (fn [acc e] (if (> e acc) e acc)) 
    args))

(my-max 1 2 3)

