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

(defn validate-input [_ input]
  (if (valid-hash? (digest/md5 input))
    (reduced (subs input 6))
    input))

(defn first-valid-hash [key]
  (reduce validate-input "" (hash-inputs key)))
