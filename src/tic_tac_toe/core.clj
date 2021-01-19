(ns tic-tac-toe.core
  (:gen-class))

(defn print-board
  "Prints the board and returns the state"
  [state]
  (map #(do (println %) %) state))

(defn -main
  "Classic game of Tic Tac Toe"
  [& args]
  (println "Hello, World!")
  (let [state [[nil nil nil] [nil nil nil] [nil nil nil]]]
    (loop [state state
           player :x]
      (cond
        (final-state state) (player-win player)
        true (do
               (read)
               (print-board state)
               (recur (make-a-move state (next-player player))
                        (next-player player)))))))

(defn make-a-move
  "Makes a move on the board
  :returns a board state

  For testing purposes it has two arrities one with a move already inserted
  and another one where the move is read from the stdin
  
  TODO: input sanitisation"
  ([state player] ;; the normal input one
   (loop [state state
          player player]
     (let [result (make-a-move state player (read))]
       (cond
         (= result :error) (recur state player) 
         true result ))))
  ([state player move] ;; the testing purposes one
   (let [row (int(/ move 3))
         col (int(mod move 3))]
     (case (nth (nth state col) row)
       nil (change-state state player row col)
       :error))))

(defn change-state
  "Returns a new state vector with the swapped state"
  [state player row col]
  (assoc state row (assoc (nth state row) col player)))

(defn final-state [state]
  false)

(defn player-win [player]
  (println "Player " player " Wins!!!"))

(defn next-player [player]
  (if (= player :x)
    :y
    :x))
