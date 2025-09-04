(ns advent.2015.day06)

(def light-grid (repeat 1000 (repeat 1000 false)))

(defn parse-instruction [instr]
  (let [[_ action x1 y1 x2 y2] (re-matches #"(turn on|turn off|toggle) (\d+),(\d+) through (\d+),(\d+)" instr)]
    [(case action
       "turn on"  (fn [_] true)
       "turn off" (fn [_] false)
       "toggle"   not)
     [x1 x2]
     [y1 y2]]))

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
