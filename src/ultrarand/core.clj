(ns ultrarand.core
  (:require [clj-java-decompiler.core :refer [decompile]]
            [ultrarand.bytecode]
            [insn.core :as insn])
  (:import [ultra Rand]
           [java.util.concurrent ThreadLocalRandom]))

(defn read-int [[n]]
  (int n))

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
                                             \w \x \y \z])]
  (defn gen-id2 []
    (let [^ThreadLocalRandom tlr (ThreadLocalRandom/current)
          l1 (.nextLong tlr) l2 (.nextLong tlr)
          rt (char-array 22)]
      (aset! rt #primitive/int[21] (aget tbl (bit-and l1 0x3f)))
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
