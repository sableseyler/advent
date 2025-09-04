(ns advent.2015.day04
  (:require [clojure.string :as str]))

(def secret-key "yzbqklnj")

(defn hash-inputs [key]
  (->> (range)
       rest
       (map str)
       (map (partial conj [key]))
       (map str/join)))
