(ns advent.2015.day03)

(def starting-state [[0 0] {[0 0] 1}])

(defn parse-move [move]
  (case move
    \^ [0 1]
    \> [1 0]
    \v [0 -1]
    \< [-1 0]))

(defn move-sleigh [[[x y] stops] [dx dy]]
  (let [pos [(+ x dx) (+ y dy)]
        given (get stops pos 0)]
    [pos (assoc stops pos (inc given))]))

(defn path-gifts [move-string]
  (->> move-string
       (map parse-move)
       (reduce move-sleigh starting-state)))

(defn count-houses [move-string]
  (count (keys (second (path-gifts move-string)))))

(defn split-step [[santa robo-santa santa?] move]
  (if santa?
    [(conj santa move) robo-santa false]
    [santa (conj robo-santa move) true]))

(defn split-routes [move-string]
  (butlast (reduce split-step [[] [] true] move-string)))

(defn count-split-houses [move-string]
  (count (keys (apply merge-with (cons + (map second (map path-gifts (split-routes move-string))))))))
