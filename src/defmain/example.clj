; lein run -m defmain.example.hello world
; lein run -m defmain.example.goodbye moon

(ns defmain.example
  (:require [defmain.core :refer [defmain]]))

(defmain hello
  [greetee]
  (println (str "Hello " greetee "!")))

(defmain goodbye
  [greetee]
  (println (str "Goodbye " greetee "!")))
