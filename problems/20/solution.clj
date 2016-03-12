(defn penultimate [s]
  ((reduce
    (fn [last-two-elems e] [(last-two-elems 1) e])
    [nil nil]
    s) 0))
