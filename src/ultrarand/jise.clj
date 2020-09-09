(ns ultrarand.jise
  (:require [jise.core :refer [defclass]]
            [clj-java-decompiler.core :refer [decompile]])
  (:import [java.util.concurrent ThreadLocalRandom]))

;; package ultra;
;; import  java.util.concurrent.ThreadLocalRandom;


;;ints => ^{:tag [int]}
;;example from AOBench..a sphere array.
;;array access is (spheres 0)
;;^:private ^{:tag [Sphere]} (def spheres)
;;array init
;;(spheres (Sphere. (Vec. -2.0 0.0 -3.5) 0.5)
;;         (Sphere. (Vec. -0.5 0.0 -3.0) 0.5)
;;         (Sphere. (Vec.  1.0 0.0 -2.2) 0.5))

^:public
(defclass Rand
  (def ^:public ^:static ^chars tbl
    (new [char] [\- \0 \1 \2 \3 \4 \5 \6 \7 \8
                 \9 \A \B \C \D \E \F \G \H \I
                 \J \K \L \M \N \O \P \Q \R \S
                 \T \U \V \W \X \Y \Z \_ \a \b
                 \c \d \e \f \g \h \i \j \k \l
                 \m \n \o \p \q \r \s \t \u \v
                 \w \x \y \z]))
  ^:public ^:static ^char
  (defm getN []
    (tbl 0))
  ^:public ^:static  ^String
  (defm genId []
    (let [^ThreadLocalRandom tlr (ThreadLocalRandom/current)
          ^long  l1 (.nextLong tlr)
          ^long  l2 (.nextLong tlr)
          ^chars rt (new [char] 22)]
      (aset rt 21 (tbl ^int (&  l1 0x3f)))
      (aset rt 20 (tbl ^int (&  (>>> l1 6) 0x3f)))
      (aset rt 19 (tbl ^int (&  (>>> l1 12) 0x3f)))
      (aset rt 18 (tbl ^int (&  (>>> l1 18) 0x3f)))
      (aset rt 17 (tbl ^int (&  (>>> l1 24) 0x3f)))
      (aset rt 16 (tbl ^int (&  (>>> l1 30) 0x3f)))
      (aset rt 15 (tbl ^int (&  (>>> l1 36) 0x3f)))
      (aset rt 14 (tbl ^int (&  (>>> l1 42) 0x3f)))
      (aset rt 13 (tbl ^int (&  (>>> l1 48) 0x3f)))
      (aset rt 12 (tbl ^int (&  (>>> l1 54) 0x3f)))
      (aset rt 11 (tbl ^int (&  (>>> l1 60) 0x3f)))
      (aset rt 10 (tbl ^int (&  l2 0x3f)))
      (aset rt 9  (tbl ^int (&  (>>> l2 6) 0x3f)))
      (aset rt 8  (tbl ^int (&  (>>> l2 12) 0x3f)))
      (aset rt 7  (tbl ^int (&  (>>> l2 18) 0x3f)))
      (aset rt 6  (tbl ^int (&  (>>> l2 24) 0x3f)))
      (aset rt 5  (tbl ^int (&  (>>> l2 30) 0x3f)))
      (aset rt 4  (tbl ^int (&  (>>> l2 36) 0x3f)))
      (aset rt 3  (tbl ^int (&  (>>> l2 42) 0x3f)))
      (aset rt 2  (tbl ^int (&  (>>> l2 48) 0x3f)))
      (aset rt 1  (tbl ^int (&  (>>> l2 54) 0x3f)))
      (aset rt 0  (tbl ^int (&  (>>> l2 60) 0x3f)))
      (String. rt))))


;; public class Rand
;; {
;;     static char[] tbl = new char[] {'-','0','1','2','3','4','5','6','7','8',
;;                                     '9','A','B','C','D','E','F','G','H','I',
;;                                     'J','K','L','M','N','O','P','Q','R','S',
;;                                     'T','U','V','W','X','Y','Z','_','a','b',
;;                                     'c','d','e','f','g','h','i','j','k','l',
;;                                     'm','n','o','p','q','r','s','t','u','v',
;;                                     'w','x','y','z'};

;;     public static String ultraRand() {
;;         ThreadLocalRandom tlr = ThreadLocalRandom.current();
;;         long l1 = tlr.nextLong(), l2 = tlr.nextLong();
;;         char[] rt = new char[22];
;;         rt[21] = tbl[(int)l1 & 0x3f]; l1 = l1 >>> 6;
;;         rt[20] = tbl[(int)l1 & 0x3f]; l1 = l1 >>> 6;
;;         rt[19] = tbl[(int)l1 & 0x3f]; l1 = l1 >>> 6;
;;         rt[18] = tbl[(int)l1 & 0x3f]; l1 = l1 >>> 6;
;;         rt[17] = tbl[(int)l1 & 0x3f]; l1 = l1 >>> 6;
;;         rt[16] = tbl[(int)l1 & 0x3f]; l1 = l1 >>> 6;
;;         rt[15] = tbl[(int)l1 & 0x3f]; l1 = l1 >>> 6;
;;         rt[14] = tbl[(int)l1 & 0x3f]; l1 = l1 >>> 6;
;;         rt[13] = tbl[(int)l1 & 0x3f]; l1 = l1 >>> 6;
;;         rt[12] = tbl[(int)l1 & 0x3f]; l1 = l1 >>> 6;
;;         rt[11] = tbl[(int)l1 & 0x3f];
;;         rt[10] = tbl[(int)l2 & 0x3f]; l2 = l2 >>> 6;
;;         rt[ 9] = tbl[(int)l2 & 0x3f]; l2 = l2 >>> 6;
;;         rt[ 8] = tbl[(int)l2 & 0x3f]; l2 = l2 >>> 6;
;;         rt[ 7] = tbl[(int)l2 & 0x3f]; l2 = l2 >>> 6;
;;         rt[ 6] = tbl[(int)l2 & 0x3f]; l2 = l2 >>> 6;
;;         rt[ 5] = tbl[(int)l2 & 0x3f]; l2 = l2 >>> 6;
;;         rt[ 4] = tbl[(int)l2 & 0x3f]; l2 = l2 >>> 6;
;;         rt[ 3] = tbl[(int)l2 & 0x3f]; l2 = l2 >>> 6;
;;         rt[ 2] = tbl[(int)l2 & 0x3f]; l2 = l2 >>> 6;
;;         rt[ 1] = tbl[(int)l2 & 0x3f]; l2 = l2 >>> 6;
;;         rt[ 0] = tbl[(int)l2 & 0x3f];
;;         return new String(rt);
;;     }
;;  }

