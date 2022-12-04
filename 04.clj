(ns adventofcode2022.04
   (:require [clojure.string :as s]))

(defn betweenInclusive
  [x a b]
  (and (<= x b)
       (>= x a)))

(defn isOverlapping
  [[aL aH bL bH]]
  (and (<= aL bH)
      (>= aH bL)))

(defn isBounding
  [[aL aH bL bH]]
  (or (and (betweenInclusive aL bL bH)
           (betweenInclusive aH bL bH))
      (and (betweenInclusive bL aL aH)
           (betweenInclusive bH aL aH))))
(defn parseInt
  [x]
  (Integer/parseInt x))

(defn solve1
  []
  (->> (slurp "./04-input.txt")
       (s/split-lines)
       (map  #(s/split % #"[^0-9]"))
       (map #(map parseInt %))
       (filter isBounding)
       count))

(defn solve2
  []
  (->> (slurp "./04-input.txt")
       (s/split-lines)
       (map  #(s/split % #"[^0-9]"))
       (map #(map parseInt %))
       (filter isOverlapping)
       count))
(solve2)
