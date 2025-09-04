(ns advent.2015.day05)

(def positive-rules [#"[aeiou].*[aeiou].*[aeiou]" ;; At least three vowels
                     #"(\p{Lower})\1"]) ;; At least one doubled letter

(def negative-rules [#"ab|cd|pq|xy"]) ;; Banned strings
