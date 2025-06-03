(ns advent.2015.day02)

(defn surface-area [l w h]
  "Find surface area from dimensions `l`, `w`, and `h`"
  (+ (* 2 l w)
     (* 2 w h)
     (* 2 h l)))
