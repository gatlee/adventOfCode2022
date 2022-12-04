(ns adventofcode2022.03
  (:require [clojure.string :as s]
            [clojure.set :as set]))

(defn getCommon
  [strInput]
  (let [[bag1 bag2] (#(split-at (/ (count %) 2) %) strInput)]
    (set/intersection (set bag1) (set bag2))))

(defn getValue
  [char]
  (let [charInt (int char)]
    (if (and (>= charInt (int \a) )
             (<= charInt (int \z) ))
      (- charInt 96)
      (+ 26 (- charInt 64 )))))

(defn solve1
  []
  (->> (slurp "./03-input.txt")
       (s/split-lines)
       (map getCommon)
       (map first)
       (map getValue)
       (apply +)))


(defn solve2
  []
  (->> (slurp "./03-input.txt")
       (s/split-lines)
       (partition 3)
       (map #(map set %))
       (map #(apply set/intersection %))
       (map first)
       (map getValue)
       (apply +)))

(solve2)
