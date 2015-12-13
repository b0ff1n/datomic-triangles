(ns datomic-triangles.core
  (:require [clojure.math.combinatorics :as combo])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn trinities [n]
  (let [sizes (range 1 n)]
    (combo/cartesian-product sizes sizes sizes)))

(defn triangle? [[a b c]]
  (and (> (+ a b) c)
       (> (+ a c) b)
       (> (+ b c) a)))


(defn triangle-objects [n]
  "Get sequence of {:a :b :c} objects of triangles with integer edge size less than n"
  (->> (trinities n)
       (filter triangle?)
       (map sort)
       (distinct)
       (map #(zipmap [:a :b :c] %))))
