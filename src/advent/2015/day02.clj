(ns advent.2015.day02
  (:require [clojure.string :as str]))

(defn surface-area [[l w h]]
  "Find surface area from dimensions `l`, `w`, and `h`"
  (+ (* 2 l w)
     (* 2 w h)
     (* 2 h l)))

(defn slack-area [dims]
  "Take the area of the smallest side, by finding the smallest edges."
  (apply * (take 2 (sort dims))))

(defn present-paper [dims]
  "Given a present with dimension seq `dims`, how much paper to wrap it?"
  (+ (surface-area dims)
     (slack-area dims)))

(defn parse-present [dimension-string]
  "Parse rectangular dimensions of the form `LENGTHxWIDTHxHEIGHT` to integers."
  (map parse-long (str/split dimension-string #"x")))

(defn process-presents [presents]
  (->> presents
       str/split-lines
       (map parse-present)
       (map present-paper)
       (reduce +)))

(defn wrapping-ribbon [dims]
  "Find the required wrapping ribbon, the smallest perimeter of any one face."
  (* 2 (apply + (take 2 (sort dims)))))

(defn bow-ribbon [dims]
  "Find the required bow ribbon, equivalent to the volume."
  (apply * dims))

(defn present-ribbon [dims]
  "Find the total ribbon to wrap the present and tie a bow."
  (+ (wrapping-ribbon dims) (bow-ribbon dims)))

(defn ribbon-presents [presents]
  (->> presents
       str/split-lines
       (map parse-present)
       (map present-ribbon)
       (reduce +)))
