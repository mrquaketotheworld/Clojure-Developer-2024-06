(ns otus-04.homework.magic-square)

;; Оригинальная задача:
;; https://www.codewars.com/kata/570b69d96731d4cf9c001597
;;
;; Подсказка: используйте "Siamese method"
;; https://en.wikipedia.org/wiki/Siamese_method

(defn magic-square
  "Функция возвращает вектор векторов целых чисел,
  описывающий магический квадрат размера n*n,
  где n - нечётное натуральное число.

  Магический квадрат должен быть заполнен так, что суммы всех вертикалей,
  горизонталей и диагоналей длиной в n должны быть одинаковы."
  [n]
  (let [square (vec (repeat n (vec (repeat n 0))))
        place-number (fn [square num row col]
                       (assoc-in square [row col] num))
        next-pos (fn [row col]
                   [(mod (- row 1) n) (mod (+ col 1) n)])]
    (loop [i 1
           row 0
           col (quot n 2)
           square square]
      (if (> i (* n n))
        square
        (let [[new-row new-col] (next-pos row col)
              [new-row new-col] (if (not= 0 (get-in square [new-row new-col]))
                                  [(mod (+ row 1) n) col]
                                  [new-row new-col])]
          (recur (inc i)
                 new-row
                 new-col
                 (place-number square i row col)))))))

; Эту задачу я решил с помощью ChatGPT, ибо самому на данном этапе мне её не решить никогда.
