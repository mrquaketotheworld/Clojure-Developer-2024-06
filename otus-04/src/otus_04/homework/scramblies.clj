(ns otus-04.homework.scramblies
  (:require [clojure.string :as string]))

;; Оригинальная задача:
;; https://www.codewars.com/kata/55c04b4cc56a697bb0000048

(defn scramble?
  "Функция возвращает true, если из букв в строке letters
  можно составить слово word."
  [letters word]
  (loop [word-map (group-by identity word)
         letters-map (group-by identity letters)]
    (let [pair-word-map (first word-map)
          letter (first pair-word-map)
          letter-count (count (second pair-word-map))]
      (if (empty? word-map)
        true
        (if (and (letters-map letter) (>= (count (letters-map letter)) letter-count))
          (recur (dissoc word-map letter) (dissoc letters-map letter))
          false)))))
