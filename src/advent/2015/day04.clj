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

(defn valid5-hash? [hash]
  (str/starts-with? hash "00000"))

(defn valid6-hash? [hash]
  (str/starts-with? hash "000000"))

(defn validate-input [valid-hash? key input]
  (if (valid-hash? (digest/md5 input))
    (reduced (subs input (count key)))
    key))

(defn first-valid-hash [validator key]
  (reduce (partial validate-input validator) key (hash-inputs key)))
