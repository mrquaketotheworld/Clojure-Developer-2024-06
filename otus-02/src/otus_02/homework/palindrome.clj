(ns otus-02.homework.palindrome
  (:require [clojure.string :as string]))

(defn is-palindrome [test-string]
  (let [test-string-clean (-> test-string
                              (string/replace #"\W" "")
                              string/lower-case)]
    (loop [start 0
           end (dec (count test-string-clean))]
      (if (= start (-> test-string
                       count
                       (/ 2)
                       double
                       Math/floor
                       int))
        true
        (if (= (get test-string-clean start) (get test-string-clean end))
          (recur (inc start) (dec end)) false)))))
