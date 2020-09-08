(ns ultrarand.core
  (:require [clj-java-decompiler.core :refer [decompile]]
            [ultrarand.bytecode]
            [insn.core :as insn])
  (:import [ultra Rand]
           [java.util.concurrent ThreadLocalRandom]))

(defn read-int [[n]]
  (int n))

(defmacro with-unchecked [& body]
  `(do (set! ~'*unchecked-math* :warn-on-boxed)
       ~@body
       (set! ~'*unchecked-math* false)))

(defmacro aset! [arr idx char]
  `(ultrarand.Arrays/asetLiteral ~arr ~idx ~char))

(let [^chars tbl (into-array Character/TYPE [\- \0 \1 \2 \3 \4 \5 \6 \7 \8
                                             \9 \A \B \C \D \E \F \G \H \I
                                             \J \K \L \M \N \O \P \Q \R \S
                                             \T \U \V \W \X \Y \Z \_ \a \b
                                             \c \d \e \f \g \h \i \j \k \l
                                             \m \n \o \p \q \r \s \t \u \v
                                             \w \x \y \z])]
  (defn gen-id []
    (let [^ThreadLocalRandom tlr (ThreadLocalRandom/current)
          l1 (.nextLong tlr) l2 (.nextLong tlr)
          rt (char-array 22)]
      (aset rt 21 (aget tbl (bit-and l1 0x3f)))
      (aset rt 20 (aget tbl (bit-and (unsigned-bit-shift-right l1 6) 0x3f)))
      (aset rt 19 (aget tbl (bit-and (unsigned-bit-shift-right l1 12) 0x3f)))
      (aset rt 18 (aget tbl (bit-and (unsigned-bit-shift-right l1 18) 0x3f)))
      (aset rt 17 (aget tbl (bit-and (unsigned-bit-shift-right l1 24) 0x3f)))
      (aset rt 16 (aget tbl (bit-and (unsigned-bit-shift-right l1 30) 0x3f)))
      (aset rt 15 (aget tbl (bit-and (unsigned-bit-shift-right l1 36) 0x3f)))
      (aset rt 14 (aget tbl (bit-and (unsigned-bit-shift-right l1 42) 0x3f)))
      (aset rt 13 (aget tbl (bit-and (unsigned-bit-shift-right l1 48) 0x3f)))
      (aset rt 12 (aget tbl (bit-and (unsigned-bit-shift-right l1 54) 0x3f)))
      (aset rt 11 (aget tbl (bit-and (unsigned-bit-shift-right l1 60) 0x3f)))
      (aset rt 10 (aget tbl (bit-and l2 0x3f)))
      (aset rt 9 (aget tbl (bit-and (unsigned-bit-shift-right l2 6) 0x3f)))
      (aset rt 8 (aget tbl (bit-and (unsigned-bit-shift-right l2 12) 0x3f)))
      (aset rt 7 (aget tbl (bit-and (unsigned-bit-shift-right l2 18) 0x3f)))
      (aset rt 6 (aget tbl (bit-and (unsigned-bit-shift-right l2 24) 0x3f)))
      (aset rt 5 (aget tbl (bit-and (unsigned-bit-shift-right l2 30) 0x3f)))
      (aset rt 4 (aget tbl (bit-and (unsigned-bit-shift-right l2 36) 0x3f)))
      (aset rt 3 (aget tbl (bit-and (unsigned-bit-shift-right l2 42) 0x3f)))
      (aset rt 2 (aget tbl (bit-and (unsigned-bit-shift-right l2 48) 0x3f)))
      (aset rt 1 (aget tbl (bit-and (unsigned-bit-shift-right l2 54) 0x3f)))
      (aset rt 0 (aget tbl (bit-and (unsigned-bit-shift-right l2 60) 0x3f)))
      (String. rt))))



(let [^chars tbl (into-array Character/TYPE [\- \0 \1 \2 \3 \4 \5 \6 \7 \8
                                             \9 \A \B \C \D \E \F \G \H \I
                                             \J \K \L \M \N \O \P \Q \R \S
                                             \T \U \V \W \X \Y \Z \_ \a \b
                                             \c \d \e \f \g \h \i \j \k \l
                                             \m \n \o \p \q \r \s \t \u \v
                                             \w \x \y \z])
      i (int 21)]
  (defn gen-id2 []
    (let [^ThreadLocalRandom tlr (ThreadLocalRandom/current)
          l1 (.nextLong tlr) l2 (.nextLong tlr)
          rt (char-array 22)]
      (aset! rt i (aget tbl (bit-and l1 0x3f)))
      (aset! rt #primitive/int[20] (aget tbl (bit-and (unsigned-bit-shift-right l1 6) 0x3f)))
      (aset! rt #primitive/int[19] (aget tbl (bit-and (unsigned-bit-shift-right l1 12) 0x3f)))
      (aset! rt #primitive/int[18] (aget tbl (bit-and (unsigned-bit-shift-right l1 18) 0x3f)))
      (aset! rt #primitive/int[17] (aget tbl (bit-and (unsigned-bit-shift-right l1 24) 0x3f)))
      (aset! rt #primitive/int[16] (aget tbl (bit-and (unsigned-bit-shift-right l1 30) 0x3f)))
      (aset! rt #primitive/int[15] (aget tbl (bit-and (unsigned-bit-shift-right l1 36) 0x3f)))
      (aset! rt #primitive/int[14] (aget tbl (bit-and (unsigned-bit-shift-right l1 42) 0x3f)))
      (aset! rt #primitive/int[13] (aget tbl (bit-and (unsigned-bit-shift-right l1 48) 0x3f)))
      (aset! rt #primitive/int[12] (aget tbl (bit-and (unsigned-bit-shift-right l1 54) 0x3f)))
      (aset! rt #primitive/int[11] (aget tbl (bit-and (unsigned-bit-shift-right l1 60) 0x3f)))
      (aset! rt #primitive/int[10] (aget tbl (bit-and l2 0x3f)))
      (aset! rt #primitive/int[9]  (aget tbl (bit-and (unsigned-bit-shift-right l2 6) 0x3f)))
      (aset! rt #primitive/int[8] (aget tbl (bit-and (unsigned-bit-shift-right l2 12) 0x3f)))
      (aset! rt #primitive/int[7] (aget tbl (bit-and (unsigned-bit-shift-right l2 18) 0x3f)))
      (aset! rt #primitive/int[6] (aget tbl (bit-and (unsigned-bit-shift-right l2 24) 0x3f)))
      (aset! rt #primitive/int[5] (aget tbl (bit-and (unsigned-bit-shift-right l2 30) 0x3f)))
      (aset! rt #primitive/int[4] (aget tbl (bit-and (unsigned-bit-shift-right l2 36) 0x3f)))
      (aset! rt #primitive/int[3] (aget tbl (bit-and (unsigned-bit-shift-right l2 42) 0x3f)))
      (aset! rt #primitive/int[2] (aget tbl (bit-and (unsigned-bit-shift-right l2 48) 0x3f)))
      (aset! rt #primitive/int[1] (aget tbl (bit-and (unsigned-bit-shift-right l2 54) 0x3f)))
      (aset! rt #primitive/int[0] (aget tbl (bit-and (unsigned-bit-shift-right l2 60) 0x3f)))
      (String. rt))))


(let [^chars tbl (into-array Character/TYPE [\- \0 \1 \2 \3 \4 \5 \6 \7 \8
                                             \9 \A \B \C \D \E \F \G \H \I
                                             \J \K \L \M \N \O \P \Q \R \S
                                             \T \U \V \W \X \Y \Z \_ \a \b
                                             \c \d \e \f \g \h \i \j \k \l
                                             \m \n \o \p \q \r \s \t \u \v
                                             \w \x \y \z])]
  (defn gen-id3 []
    (let [^ThreadLocalRandom tlr (ThreadLocalRandom/current)
          l1 (.nextLong tlr) l2 (.nextLong tlr)
          rt (char-array 22)]
      (aset! rt 21 (aget tbl (bit-and l1 0x3f)))
      (aset! rt 20 (aget tbl (bit-and (unsigned-bit-shift-right l1 6) 0x3f)))
      (aset! rt 19 (aget tbl (bit-and (unsigned-bit-shift-right l1 12) 0x3f)))
      (aset! rt 18 (aget tbl (bit-and (unsigned-bit-shift-right l1 18) 0x3f)))
      (aset! rt 17 (aget tbl (bit-and (unsigned-bit-shift-right l1 24) 0x3f)))
      (aset! rt 16 (aget tbl (bit-and (unsigned-bit-shift-right l1 30) 0x3f)))
      (aset! rt 15 (aget tbl (bit-and (unsigned-bit-shift-right l1 36) 0x3f)))
      (aset! rt 14 (aget tbl (bit-and (unsigned-bit-shift-right l1 42) 0x3f)))
      (aset! rt 13 (aget tbl (bit-and (unsigned-bit-shift-right l1 48) 0x3f)))
      (aset! rt 12 (aget tbl (bit-and (unsigned-bit-shift-right l1 54) 0x3f)))
      (aset! rt 11 (aget tbl (bit-and (unsigned-bit-shift-right l1 60) 0x3f)))
      (aset! rt 10 (aget tbl (bit-and l2 0x3f)))
      (aset! rt 9 (aget tbl (bit-and (unsigned-bit-shift-right l2 6) 0x3f)))
      (aset! rt 8 (aget tbl (bit-and (unsigned-bit-shift-right l2 12) 0x3f)))
      (aset! rt 7 (aget tbl (bit-and (unsigned-bit-shift-right l2 18) 0x3f)))
      (aset! rt 6 (aget tbl (bit-and (unsigned-bit-shift-right l2 24) 0x3f)))
      (aset! rt 5 (aget tbl (bit-and (unsigned-bit-shift-right l2 30) 0x3f)))
      (aset! rt 4 (aget tbl (bit-and (unsigned-bit-shift-right l2 36) 0x3f)))
      (aset! rt 3 (aget tbl (bit-and (unsigned-bit-shift-right l2 42) 0x3f)))
      (aset! rt 2 (aget tbl (bit-and (unsigned-bit-shift-right l2 48) 0x3f)))
      (aset! rt 1 (aget tbl (bit-and (unsigned-bit-shift-right l2 54) 0x3f)))
      (aset! rt 0 (aget tbl (bit-and (unsigned-bit-shift-right l2 60) 0x3f)))
      (String. rt))))

(with-unchecked 
(let [^chars tbl (into-array Character/TYPE [\- \0 \1 \2 \3 \4 \5 \6 \7 \8
                                             \9 \A \B \C \D \E \F \G \H \I
                                             \J \K \L \M \N \O \P \Q \R \S
                                             \T \U \V \W \X \Y \Z \_ \a \b
                                             \c \d \e \f \g \h \i \j \k \l
                                             \m \n \o \p \q \r \s \t \u \v
                                             \w \x \y \z])]
  (defn gen-id4 []
    (let [^ThreadLocalRandom tlr (ThreadLocalRandom/current)
          l1 (.nextLong tlr) l2 (.nextLong tlr)
          rt (char-array 22)]
      (aset! rt 21 (aget tbl (bit-and l1 0x3f)))
      (aset! rt 20 (aget tbl (bit-and (unsigned-bit-shift-right l1 6) 0x3f)))
      (aset! rt 19 (aget tbl (bit-and (unsigned-bit-shift-right l1 12) 0x3f)))
      (aset! rt 18 (aget tbl (bit-and (unsigned-bit-shift-right l1 18) 0x3f)))
      (aset! rt 17 (aget tbl (bit-and (unsigned-bit-shift-right l1 24) 0x3f)))
      (aset! rt 16 (aget tbl (bit-and (unsigned-bit-shift-right l1 30) 0x3f)))
      (aset! rt 15 (aget tbl (bit-and (unsigned-bit-shift-right l1 36) 0x3f)))
      (aset! rt 14 (aget tbl (bit-and (unsigned-bit-shift-right l1 42) 0x3f)))
      (aset! rt 13 (aget tbl (bit-and (unsigned-bit-shift-right l1 48) 0x3f)))
      (aset! rt 12 (aget tbl (bit-and (unsigned-bit-shift-right l1 54) 0x3f)))
      (aset! rt 11 (aget tbl (bit-and (unsigned-bit-shift-right l1 60) 0x3f)))
      (aset! rt 10 (aget tbl (bit-and l2 0x3f)))
      (aset! rt 9 (aget tbl (bit-and (unsigned-bit-shift-right l2 6) 0x3f)))
      (aset! rt 8 (aget tbl (bit-and (unsigned-bit-shift-right l2 12) 0x3f)))
      (aset! rt 7 (aget tbl (bit-and (unsigned-bit-shift-right l2 18) 0x3f)))
      (aset! rt 6 (aget tbl (bit-and (unsigned-bit-shift-right l2 24) 0x3f)))
      (aset! rt 5 (aget tbl (bit-and (unsigned-bit-shift-right l2 30) 0x3f)))
      (aset! rt 4 (aget tbl (bit-and (unsigned-bit-shift-right l2 36) 0x3f)))
      (aset! rt 3 (aget tbl (bit-and (unsigned-bit-shift-right l2 42) 0x3f)))
      (aset! rt 2 (aget tbl (bit-and (unsigned-bit-shift-right l2 48) 0x3f)))
      (aset! rt 1 (aget tbl (bit-and (unsigned-bit-shift-right l2 54) 0x3f)))
      (aset! rt 0 (aget tbl (bit-and (unsigned-bit-shift-right l2 60) 0x3f)))
      (String. rt)))))


(defmacro asetl! [arr idx v]
  `(ultrarand.Arrays/asetLiteral ~arr ~idx ~v))

(with-unchecked 
(let [^chars tbl (into-array Character/TYPE [\- \0 \1 \2 \3 \4 \5 \6 \7 \8
                                             \9 \A \B \C \D \E \F \G \H \I
                                             \J \K \L \M \N \O \P \Q \R \S
                                             \T \U \V \W \X \Y \Z \_ \a \b
                                             \c \d \e \f \g \h \i \j \k \l
                                             \m \n \o \p \q \r \s \t \u \v
                                             \w \x \y \z])]
  (defn gen-id5 []
    (let [^ThreadLocalRandom tlr (ThreadLocalRandom/current)
          l1 (.nextLong tlr) l2 (.nextLong tlr)
          rt (char-array 22)]
      (asetl! rt 21 (aget tbl (bit-and l1 0x3f)))
      (asetl! rt 20 (aget tbl (bit-and (unsigned-bit-shift-right l1 6) 0x3f)))
      (asetl! rt 19 (aget tbl (bit-and (unsigned-bit-shift-right l1 12) 0x3f)))
      (asetl! rt 18 (aget tbl (bit-and (unsigned-bit-shift-right l1 18) 0x3f)))
      (asetl! rt 17 (aget tbl (bit-and (unsigned-bit-shift-right l1 24) 0x3f)))
      (asetl! rt 16 (aget tbl (bit-and (unsigned-bit-shift-right l1 30) 0x3f)))
      (asetl! rt 15 (aget tbl (bit-and (unsigned-bit-shift-right l1 36) 0x3f)))
      (asetl! rt 14 (aget tbl (bit-and (unsigned-bit-shift-right l1 42) 0x3f)))
      (asetl! rt 13 (aget tbl (bit-and (unsigned-bit-shift-right l1 48) 0x3f)))
      (asetl! rt 12 (aget tbl (bit-and (unsigned-bit-shift-right l1 54) 0x3f)))
      (asetl! rt 11 (aget tbl (bit-and (unsigned-bit-shift-right l1 60) 0x3f)))
      (asetl! rt 10 (aget tbl (bit-and l2 0x3f)))
      (asetl! rt 9 (aget tbl (bit-and (unsigned-bit-shift-right l2 6) 0x3f)))
      (asetl! rt 8 (aget tbl (bit-and (unsigned-bit-shift-right l2 12) 0x3f)))
      (asetl! rt 7 (aget tbl (bit-and (unsigned-bit-shift-right l2 18) 0x3f)))
      (asetl! rt 6 (aget tbl (bit-and (unsigned-bit-shift-right l2 24) 0x3f)))
      (asetl! rt 5 (aget tbl (bit-and (unsigned-bit-shift-right l2 30) 0x3f)))
      (asetl! rt 4 (aget tbl (bit-and (unsigned-bit-shift-right l2 36) 0x3f)))
      (asetl! rt 3 (aget tbl (bit-and (unsigned-bit-shift-right l2 42) 0x3f)))
      (asetl! rt 2 (aget tbl (bit-and (unsigned-bit-shift-right l2 48) 0x3f)))
      (asetl! rt 1 (aget tbl (bit-and (unsigned-bit-shift-right l2 54) 0x3f)))
      (asetl! rt 0 (aget tbl (bit-and (unsigned-bit-shift-right l2 60) 0x3f)))
      (String. rt)))))


(with-unchecked 
(let [^chars tbl (into-array Character/TYPE [\- \0 \1 \2 \3 \4 \5 \6 \7 \8
                                             \9 \A \B \C \D \E \F \G \H \I
                                             \J \K \L \M \N \O \P \Q \R \S
                                             \T \U \V \W \X \Y \Z \_ \a \b
                                             \c \d \e \f \g \h \i \j \k \l
                                             \m \n \o \p \q \r \s \t \u \v
                                             \w \x \y \z])
      i0 (int 0)
      i1 (int 1)
      i2 (int 2)
      i3 (int 3)
      i4 (int 4)
      i5 (int 5)
      i6 (int 6)
      i7 (int 7)
      i8 (int 8)
      i9 (int 9)
      i10 (int 10)
      i11 (int 11)
      i12 (int 12)
      i13 (int 13)
      i14 (int 14)
      i15 (int 15)
      i16 (int 16)
      i17 (int 17)
      i18 (int 18)
      i19 (int 19)
      i20 (int 20)
      i21 (int 21)]
  (defn gen-id6 []
    (let [^ThreadLocalRandom tlr (ThreadLocalRandom/current)
          l1 (.nextLong tlr) l2 (.nextLong tlr)
          rt (char-array 22)]
      (aset! rt i21 (aget tbl (bit-and l1 0x3f)))
      (aset! rt i20 (aget tbl (bit-and (unsigned-bit-shift-right l1 6) 0x3f)))
      (aset! rt i19 (aget tbl (bit-and (unsigned-bit-shift-right l1 12) 0x3f)))
      (aset! rt i18 (aget tbl (bit-and (unsigned-bit-shift-right l1 18) 0x3f)))
      (aset! rt i17 (aget tbl (bit-and (unsigned-bit-shift-right l1 24) 0x3f)))
      (aset! rt i16 (aget tbl (bit-and (unsigned-bit-shift-right l1 30) 0x3f)))
      (aset! rt i15 (aget tbl (bit-and (unsigned-bit-shift-right l1 36) 0x3f)))
      (aset! rt i14 (aget tbl (bit-and (unsigned-bit-shift-right l1 42) 0x3f)))
      (aset! rt i13 (aget tbl (bit-and (unsigned-bit-shift-right l1 48) 0x3f)))
      (aset! rt i12 (aget tbl (bit-and (unsigned-bit-shift-right l1 54) 0x3f)))
      (aset! rt i11 (aget tbl (bit-and (unsigned-bit-shift-right l1 60) 0x3f)))
      (aset! rt i10 (aget tbl (bit-and l2 0x3f)))
      (aset! rt i9 (aget tbl (bit-and (unsigned-bit-shift-right l2 6) 0x3f)))
      (aset! rt i8 (aget tbl (bit-and (unsigned-bit-shift-right l2 12) 0x3f)))
      (aset! rt i7 (aget tbl (bit-and (unsigned-bit-shift-right l2 18) 0x3f)))
      (aset! rt i6 (aget tbl (bit-and (unsigned-bit-shift-right l2 24) 0x3f)))
      (aset! rt i5 (aget tbl (bit-and (unsigned-bit-shift-right l2 30) 0x3f)))
      (aset! rt i4 (aget tbl (bit-and (unsigned-bit-shift-right l2 36) 0x3f)))
      (aset! rt i3 (aget tbl (bit-and (unsigned-bit-shift-right l2 42) 0x3f)))
      (aset! rt i2 (aget tbl (bit-and (unsigned-bit-shift-right l2 48) 0x3f)))
      (aset! rt i1 (aget tbl (bit-and (unsigned-bit-shift-right l2 54) 0x3f)))
      (aset! rt i0 (aget tbl (bit-and (unsigned-bit-shift-right l2 60) 0x3f)))
      (String. rt)))))

;; ultrarand.core> (c/quick-bench (ultra.Rand/ultraRand))
;; Evaluation count : 22333938 in 6 samples of 3722323 calls.
;; Execution time mean : 25.350240 ns
;; Execution time std-deviation : 0.702761 ns
;; Execution time lower quantile : 24.477653 ns ( 2.5%)
;; Execution time upper quantile : 26.195979 ns (97.5%)
;; Overhead used : 1.809749 ns
;; nil

;; ultrarand.core> (c/quick-bench (gen-id))
;; Evaluation count : 17528856 in 6 samples of 2921476 calls.
;; Execution time mean : 32.671509 ns
;; Execution time std-deviation : 0.379434 ns
;; Execution time lower quantile : 32.109818 ns ( 2.5%)
;; Execution time upper quantile : 33.081279 ns (97.5%)
;; Overhead used : 1.809749 ns
;; nil

;; ultrarand.core> (c/quick-bench (gen-id2))
;; Evaluation count : 18260664 in 6 samples of 3043444 calls.
;; Execution time mean : 32.656578 ns
;; Execution time std-deviation : 0.417487 ns
;; Execution time lower quantile : 32.114286 ns ( 2.5%)
;; Execution time upper quantile : 33.113832 ns (97.5%)
;; Overhead used : 1.809749 ns
;; nil

;; ultrarand.core> (c/quick-bench (gen-id3))
;; Evaluation count : 17702988 in 6 samples of 2950498 calls.
;; Execution time mean : 33.010972 ns
;; Execution time std-deviation : 0.884933 ns
;; Execution time lower quantile : 32.281852 ns ( 2.5%)
;; Execution time upper quantile : 34.446063 ns (97.5%)
;; Overhead used : 1.809749 ns

;; Found 1 outliers in 6 samples (16.6667 %)
;; low-severe	 1 (16.6667 %)
;; Variance from outliers : 13.8889 % Variance is moderately inflated by outliers
;; nil

;; ultrarand.core> (c/quick-bench (gen-id5))
;; Evaluation count : 19591800 in 6 samples of 3265300 calls.
;; Execution time mean : 28.810365 ns
;; Execution time std-deviation : 0.704151 ns
;; Execution time lower quantile : 27.964828 ns ( 2.5%)
;; Execution time upper quantile : 29.663485 ns (97.5%)
;; Overhead used : 1.786742 ns
;; nil


;;Counter intuitive
;; ultrarand.core> (c/quick-bench (gen-id6))
;; Evaluation count : 16751784 in 6 samples of 2791964 calls.
;; Execution time mean : 34.806280 ns
;; Execution time std-deviation : 0.961793 ns
;; Execution time lower quantile : 34.010246 ns ( 2.5%)
;; Execution time upper quantile : 36.378346 ns (97.5%)
;; Overhead used : 1.786742 ns

;; Found 1 outliers in 6 samples (16.6667 %)
;; low-severe	 1 (16.6667 %)
;; Variance from outliers : 13.8889 % Variance is moderately inflated by outliers
;; nil
