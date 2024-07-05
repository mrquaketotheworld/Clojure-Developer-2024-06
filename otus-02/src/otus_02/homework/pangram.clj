(ns otus-02.homework.pangram
  (:require [clojure.string :as string]))

(defn is-pangram [test-string]
  (let [alphabet "abcdefghijklmnopqrstuvwxyz"
        test-string-lower (string/lower-case test-string)]
    (every? #(string/index-of test-string-lower %) alphabet)))
