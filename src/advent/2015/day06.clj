(ns advent.2015.day06)

(def light-grid (repeat 1000 (repeat 1000 false)))

(def int-grid (repeat 1000 (repeat 1000 0)))

(defn parse-instruction [instr]
  (let [[_ action x1 y1 x2 y2] (re-matches #"(turn on|turn off|toggle) (\d+),(\d+) through (\d+),(\d+)" instr)]
    [(case action
       "turn on"  (fn [_] true)
       "turn off" (fn [_] false)
       "toggle"   not)
     (map parse-long [x1 x2])
     (map parse-long [y1 y2])]))

(defn parse-int-instruction [instr]
  (let [[_ action x1 y1 x2 y2] (re-matches #"(turn on|turn off|toggle) (\d+),(\d+) through (\d+),(\d+)" instr)]
    [(case action
       "turn on"  inc
       "turn off" dec
       "toggle"   #(+ 2 %))
     (map parse-long [x1 x2])
     (map parse-long [y1 y2])]))

(defn change-lights [grid [action [x1 x2] [y1 y2]]]
  (map-indexed (fn [x row]
                 (if (and (>= x x1)
                          (<= x x2))
                   (map-indexed (fn [y light]
                                  (if (and (>= y y1)
                                           (<= y y2))
                                    (action light)
                                    light))
                                row)
                   row))
               grid))

(defn configure-lights [instructions]
  (->> instructions
       (map parse-instruction)
       (reduce change-lights light-grid)))

(defn configure-int-lights [instructions]
  (->> instructions
       (map parse-int-instruction)
       (reduce change-lights int-grid)))

(defn count-lights [grid]
  (->> grid
       (map (partial filter identity))
       (map count)
       (reduce +)))

(defn sum-brightness [grid]
  (->> grid
       (map (partial reduce +))
       (reduce +)))

(defn count-santa-lights [instructions]
  (-> instructions
      configure-lights
      count-lights))

(defn sum-santa-lights [instructions]
  (-> instructions
      configure-int-lights
      sum-brightness))
