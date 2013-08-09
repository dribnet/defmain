(ns defmain.core)

; code shamelessly ripped from cascalog-core

(defn meta-conj
  "Returns the supplied symbol with the supplied `attr` map conj-ed
  onto the symbol's current metadata."
  [sym attr]
  (with-meta sym (if (meta sym)
                   (conj (meta sym) attr)
                   attr)))

(defmacro defmain
  "Defines an AOT-compiled function with the supplied
  `name`. Containing namespace must be marked for AOT compilation to
  have any effect."
  [name & forms]
  (let [classname (namespace-munge (str *ns* "." name))
        sym (with-meta
              (symbol (str name "-main"))
              (meta name))]
    `(do (gen-class :name ~classname
                    :main true
                    :prefix ~(str name "-"))
         (defn ~(meta-conj sym {:no-doc true
                                :skip-wiki true})
           ~@forms)
         (defn ~name ~@forms))))
