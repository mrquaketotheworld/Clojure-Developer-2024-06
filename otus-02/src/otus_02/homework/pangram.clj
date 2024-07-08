(ns otus-02.homework.pangram
  (:require [clojure.string :as string]))

(defn in-alphabet? [c]
  (and (>= (int c) (int \a)) (<= (int c) (int \z))))

(def alphabet-length 26)

(defn is-pangram [test-string]
  (loop [str test-string
         chars #{}]
    (if (empty? str)
      (if (= (count chars) alphabet-length) true false)
      (let [str-char (.charAt (string/lower-case (first str)) 0)]
        (if (in-alphabet? str-char)
          (recur (rest str) (conj chars str-char))
          (recur (rest str) chars))))))
