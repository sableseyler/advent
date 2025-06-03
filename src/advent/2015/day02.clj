(ns advent.2015.day02)

(defn surface-area [l w h]
  "Find surface area from dimensions `l`, `w`, and `h`"
  (+ (* 2 l w)
     (* 2 w h)
     (* 2 h l)))

(defn slack-area [l w h]
  "Take the area of the smallest side, by finding the smallest edges."
  (apply * (take 2 (sort [l w h]))))

(defn present-paper [l w h]
  "Given a present with dimensions `l`, `w`, and `h`, how much paper to wrap it?"
  (+ (surface-area l w h)
     (slack-area l w h)))
