(ns adventofcode2022.02
  (:require [clojure.string :as s]))


(def moves [:r :p :s])
(.indexOf moves :r)

(defn getWinningMove
  [enemyMove]
  (nth (cycle moves) (+ 4 (.indexOf moves enemyMove))))

(defn getLosingMove
  [enemyMove]
  (nth (cycle moves) (+ 2 (.indexOf moves enemyMove))))

(defn str->RPS
  [str]
  (case str
      ("A" "X") :r
      ("B" "Y") :p
      ("C" "Z") :s))

(defn score
  [[enemy mine]]
  (+ (cond
       (= mine (getWinningMove enemy))   6
       (= enemy mine) 3
       :else 0)

     (inc (.indexOf moves mine))))

(defn part1
  []
  (->>
   (slurp "02-input.txt")
   (s/split-lines)
   (map s/trim)
   (map #(s/split % #" "))
   (map #(map str->RPS %))
   (map score)
   (apply +)))

(defn getMove
  [enemyMove instruction]
  (case instruction
    "X" (getLosingMove enemyMove)
    "Y" enemyMove
    "Z" (getWinningMove enemyMove)))

(defn strTuple->RPSInstruction
  [[enemyStr instruction]]
  (let [enemyMove (str->RPS enemyStr)]
    [enemyMove (getMove enemyMove instruction)]))

(defn part2
  []
  (->>
   (slurp "02-input.txt")
   (s/split-lines)
   (map s/trim)
   (map #(s/split % #" "))
   (map strTuple->RPSInstruction)
   (map score)
   (apply +)))

(part1)
(part2)
