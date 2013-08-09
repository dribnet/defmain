# defmain

A Clojure library designed to make main entry points easy.

Code shamelessly pulled from [cascalog core](http://nathanmarz.github.io/cascalog/cascalog.api.html#var-defmain). This is just meant to be a version with a much lighter dependecy footprint.

## Usage

```clj
(defmain hello
  [greetee]
  (println (str "Hello " greetee "!")))
```

```
$ lein run -m my.ns.hello world
Hello world!
$ java -cp target/my-uberjar.jar my.ns.hello world
Hello world!
```

## License

Copyright © 2013 Tom White and/or

Copyright (c) 2010-2011 Nathan Marz. All Rights Reserved.

Project and contact information: http://www.cascalog.org/

Distributed under the Eclipse Public License, the same as Cascalog & Clojure.
