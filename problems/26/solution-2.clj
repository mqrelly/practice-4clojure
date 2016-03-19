(defn fibonacci [n]
  (let [lazy-fib
        (fn lazy-fib [a b] (lazy-seq (cons a (lazy-fib b (+' a b)))))]
    (take n (lazy-fib 1 1))))
