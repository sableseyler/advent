(ns advent.2015.day05)

(def ruleset1 [[#"[aeiou].*[aeiou].*[aeiou]" ;; At least three vowels
                #"(\p{Lower})\1"] ;; At least one doubled letter

               [#"ab|cd|pq|xy"]]) ;; Banned strings

(def ruleset2 [[#"(\p{Lower}{2}).*\1" ;; Duplicate non-overlapping letter pair
                #"(\p{Lower})\p{Lower}\1"] ;; Repeat letter with middle

               []]) ;; No negative rules

(defn nice? [[positive-rules negative-rules] s]
  (and (if (seq positive-rules) (every? #(re-find % s) positive-rules) true)
       (if (seq negative-rules) (not-any? #(re-find % s) negative-rules) true)))

(defn count-niceness [ruleset strings]
  (count (filter (partial nice? ruleset) strings)))
