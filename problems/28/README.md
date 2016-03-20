# 28. - Flatten a Sequence

Write a function which flattens a sequence.


## Examples

    (= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))

    (= (__ ["a" ["b"] "c"]) '("a" "b" "c"))

    (= (__ '((((:a))))) '(:a))
