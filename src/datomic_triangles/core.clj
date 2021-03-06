(ns datomic-triangles.core
  (:require [clojure.math.combinatorics :as combo])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))


(def props [])

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

(defn enrich-triangle [{:keys [a b c] :as obj}]
  (let []
    (assoc obj
      :a_square (* a a)
      :b_square (* b b)
      :c_square (* c c)
      :perimiter (+ a b c))))
