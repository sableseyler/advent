(ns advent.2015.day04
  (:require [clojure.string :as str]
            [clj-commons.digest :as digest]))

(def secret-key "yzbqklnj")

(defn hash-inputs [key]
  (->> (range)
       rest
       (map str)
       (map (partial conj [key]))
       (map str/join)))

(defn valid-hash? [hash]
  (str/starts-with? hash "00000"))
