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
