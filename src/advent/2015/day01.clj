(ns advent.2015.day01)

(defn count-paren [paren]
  "Return `1` for open parens, and `-1` for close parens."
  (case paren
        \( 1
        \) -1))

(defn find-floor [route]
  "Given a string of paren-based floor-routing `route`, identify the destination."
  (apply + (map count-paren route)))
