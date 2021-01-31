(ns tic-tac-toe.core
  (:gen-class))

(defn print-board
  "Prints the board and returns the state"
  [state]
  (println "Entered the board")
  (doall (map #(do (println %) %) state)))

(defn change-state
  "Returns a new state vector with the swapped state"
  [state player row col]
  (do (println col "-" row )
      (assoc state row (assoc (nth state row) col player))))

(defn swapper
  "A swapper that helps calculate if there are 3 of a kind on any given row"
  [x]
  (case x
    :o 1
    :x -1
    0))

(defn swapper-winner
  "A swapper that only swaps the winning sums of 3 or -3
  Takes in"
  [x]
  (case x
    3 true
    -3 true
    false))

(defn row-colapser
  "Calculates the total points per row received"
  [state]
  (map (fn [x] (reduce + x)) state)) 

(defn state-converter
  "converts a received vetor to numerical values"
  [x]
  (do (map (fn [x] (map (fn [x] (swapper x)) x)) x)))

(defn row-calculate
  "Calculates if there are 3 in a row"
  [state]
  (reduce (fn [x y] (or x y))(map swapper-winner (row-colapser (state-converter state)))))

(defn column-colapse
  "colapse columns into one vector"
  [state]
  (reduce (fn [carry line]
            (let [[x y z] line
                  [xc yc zc] carry]
              [(+ xc x) (+ y yc) (+ z zc)])) state))

(defn column-calculate
  "Calculate if there are 3 in a column"
  [state]
  (->> state
       (state-converter ,,,)
       (column-colapse ,,,)
       (map swapper-winner ,,,)
       (reduce (fn [x y] (or x y)) ,,,)))

(defn final-state [state]
  (cond
    (row-calculate state) true
    true false))

(defn player-win [player]
  (println "Player " player " Wins!!!"))

(defn next-player [player]
  (if (= player :x)
    :o
    :x))

(defn initial-state []
  [[nil nil nil] [nil nil nil] [nil nil nil]])


(defn test-state []
  [[:x nil nil] [:x nil nil] [:x nil nil]])


(defn test-state-2 []
  [[:o :x :x] [:x nil nil] [:x nil nil]])

(defn test-state-3
  "Returns a winning row state"
  []
  [[:x nil nil] [:x nil :o] [:x nil :o]])

(defn diagonal-map
  "returns a map to filter everything but the diagonals"
  []
  [[true false true] [false true false] [true false true]])


;; TODO 
(defn diagonal-solve
  "returns true if the diagoanls are solved"
  [state]
  (-> state
      (map (diagonal-map) ,,,)          ;zip it together with the filter map
      ))

;; sketch for the above
;; TO DO
(map (fn [x] (let [[l r] x] (and r l))) (map vector (diagonal-map) (test-state)))


(defn make-a-move
  "Makes a move on the board
  :returns a board state
  
  For testing purposes it has two arrities one with a move already inserted
  and another one where the move is read from the stdin
  
  TODO: input sanitisation"
  
  ([state player]                            ;; the normal input version
   (loop [state state
          player player]
     (let [result (make-a-move state player (dec(int(read))))]
       (cond
         (= result :error) (recur state player) 
         true result ))))
  
  ([state player move]                       ;; the testing purposes one
   (let [row (int(/ move 3))
         col (int(mod move 3))]
     (do (println row "-" col))
     (case (nth (nth state row) col)
       nil (change-state state player row col)
       :error))))


(defn -main
  "Classic game of Tic Tac Toe"
  [& args]
  (println "Hello, World!")
  (let [state (initial-state)]
    (loop [state state
           player :x]
      (print-board state)
      (cond
        (final-state state) (player-win player)
        true (do
               (recur (make-a-move state (next-player player))
                      (next-player player)))))))
