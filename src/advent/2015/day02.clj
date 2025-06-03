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
