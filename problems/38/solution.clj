(defn my-max
  [& args]
  (reduce 
    (fn [e acc] (if (> e acc) e acc)) 
    args))

(my-max 1 2 3)

