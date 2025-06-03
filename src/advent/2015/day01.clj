(ns advent.2015.day01)

(defn count-paren [paren]
  "Return `1` for open parens, and `-1` for close parens."
  (case paren
        \( 1
        \) -1))
