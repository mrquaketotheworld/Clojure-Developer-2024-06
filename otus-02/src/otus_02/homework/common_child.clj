(ns otus-02.homework.common-child
  (:require [clojure.string :as string]))

;; Строка называется потомком другой строки,
;; если она может быть образована путем удаления 0 или более символов из другой строки.
;; Буквы нельзя переставлять.
;; Имея две строки одинаковой длины, какую самую длинную строку можно построить так,
;; чтобы она была потомком обеих строк?

;; Например 'ABCD' и 'ABDC'

;; Эти строки имеют два дочерних элемента с максимальной длиной 3, ABC и ABD.
;; Их можно образовать, исключив D или C из обеих строк.
;; Ответ в данном случае - 3

;; Еще пример HARRY и SALLY. Ответ будет - 2, так как общий элемент у них AY

(defn common-child-length [first-string second-string]
  (loop [char-set #{}
         xs first-string]
    (if (not-empty xs)
      (if (string/index-of second-string (get xs 0))
        (recur (conj char-set (get xs 0)) (subs xs 1))
        (recur char-set (subs xs 1)))
      (count char-set))))
