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

(defn validate-input [key input]
  (if (valid-hash? (digest/md5 input))
    (reduced (subs input (count key)))
    key))

(defn first-valid-hash [key]
  (reduce validate-input key (hash-inputs key)))
