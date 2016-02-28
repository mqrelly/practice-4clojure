(def maze["#######"
          "#     #"
          "#  #  #"
          "#M # C#"
          "#######"])

(defn maze-solvable? [maze]
  (let [width (count (nth maze 0))
        height (count maze)

        get-maze (fn [maze x y]
                   (nth (nth maze y) x))

        set-maze (fn [maze x y v]
                   (assoc maze y
                          (assoc (into [] (nth maze y)) x v)))

        find-in-maze (fn [maze v]
                       (loop [x 0 y 0]
                         (if (= (get-maze maze x y) v)
                           {:x x :y y}
                           (recur
                             (mod (inc x) width)
                             (if (< (/ (inc x) width) 1)
                               y
                               (inc y))))))

        get-neighbours (fn [field]
                         (->> [{:y 1} {:y -1} {:x 1} {:x -1}]
                              (map #(hash-map
                                      :x (+ (:x field) (or (:x %) 0))
                                      :y (+ (:y field) (or (:y %) 0))
                                      ))
                              (filter #(and (< -1 (:x %) width) (< -1 (:y %) height)))))
        ]

    (loop [current-maze maze
           frontier     [(find-in-maze maze \M)]]

      (let [field  (first frontier)
            x      (:x field)
            y      (:y field)]

        (if (empty? field)
          false
          (case (get-maze current-maze x y)
            \C      true
            (\m \#) (recur current-maze (into [] (rest frontier)))
            (\M \space) (recur
                          (set-maze current-maze x y \m)
                          (into (into [] (rest frontier)) (get-neighbours field)))))))))

