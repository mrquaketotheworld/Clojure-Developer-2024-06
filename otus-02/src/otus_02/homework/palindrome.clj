(ns otus-02.homework.palindrome
  (:require [clojure.string :as string]))

(defn is-palindrome [test-string]
  (let [test-string-clean (-> test-string
                              (string/replace #"\W" "")
                              string/lower-case)]
    (= test-string-clean (string/reverse test-string-clean))))
