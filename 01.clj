(ns adventofcode2022.01
  (:require [clojure.string :as s]))

(def isEmptyList
  #(and (= 1 (count % ))
        (s/blank? (first %))))

(defn parseInt
  [x]
  (Integer/parseInt x))

(->> (slurp "01-input.txt")
     (s/split-lines)
     (partition-by empty?)
     (filter (complement isEmptyList))
     (map #(map parseInt %))
     (map #(apply + %))
     (apply max))


(->> (slurp "01-input.txt")
     (s/split-lines)
     (partition-by empty?)
     (filter (complement isEmptyList))
     (map #(map parseInt %))
     (map #(apply + %))
     (sort)
     (take-last 3)
     (apply +))
