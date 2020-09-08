(ns ultrarand.bytecode
  (:require [insn.core :as insn]
            [insn.op :as op]))

(insn/new-instance
 {:name "ultrarand.Arrays"
  :flags  #{:public}
  :methods [{:flags #{:public :static}, :name "asetLiteral", :desc [chars :int :char :char]  ;; <-- here
             :emit [[:aload 0]
                    [:iload 1]
                    [:iload 2]
                    [:castore]
                    [:iload 2]
                    [:ireturn]]}]})


;; public class blah.demo
;; {public blah.demo();
;;  Code:
;;  0: aload_0
;;  1: invokespecial #1                  // Method java/lang/Object."<init>":()V
;;  4: return

;;  public static int aset(int[], int, int);
;;  Code:
;;  0: iload_2
;;  1: ireturn}


;; public class demo
;; {public static char aset(char [] arr, int idx, char v)
;;   {arr[idx] = v;
;;    return v;
;;    }}

;; public class blah.demo
;; {public blah.demo();
;;  Code:
;;  0: aload_0
;;  1: invokespecial #1                  // Method java/lang/Object."<init>":()V
;;  4: return

;;  public static char aset(char[], int, char);
;;  Code:
;;  0: aload_0
;;  1: iload_1
;;  2: iload_2
;;  3: castore
;;  4: iload_2
;;  5: ireturn
;;  }

#_
(def class-data
  {:name    'my.pkg.Adder
   :flags  #{:public}
   :methods [{:flags #{:public :static}, :name "asetLiteral", :desc [chars :int :char :char]
              :fields []
              :emit [[:aload 0]
                     [:iload 1]
                     [:iload 2]
                     [:castore]
                     [:iload 2]
                     [:ireturn]]}]})

#_
{:name "test.Klass"
 :flags  #{:public}
 :methods [{:flags #{:public :static}, :name "asetLiteral", :desc [chars :int :char :char]  ;; <-- here
            :emit [[:aload 0]
                   [:iload 1]
                   [:iload 2]
                   [:castore]
                   [:iload 2]
                   [:ireturn]]}]}

#_(def class-object (insn/define class-data))
#_(def obj (-> class-object .newInstance))

#_(def class-data2
  {:name    'my.pkg.Adder
   :flags  #{:public}
   :fields  []
   :methods [{:flags #{:public :static}, :name "asetLiteral", :desc [ints :int :int]
              :emit [[:iload 2]
                     [:ireturn]]}]})

;; package my.pkg;

;; public class Adder {
;;                     public static long VALUE = 42;
;;                     public long add (long n) {
;;                                               return VALUE + n;
;;                                               }
;;                     }

#_
(def class-data
  {:name    'my.pkg.Adder
   :fields  [#_{:flags #{:public :static}, :name "VALUE", :type :long, :value 42}]
   :methods [{:flags #{:public :static}, :name "asetLiteral", :desc [:chars :int :int]
              :emit [[:getstatic :this "VALUE" :long]
                     [:lload 1]
                     [:ladd]
                     [:lreturn]]}]})

;; (def a (into-array Character/TYPE "foo"))

;; (insn/new-instance
;;  {:name "test.Klass"
;;   :flags  #{:public}
;;   :methods [{:flags #{:public :static}, :name "asetLiteral", :desc [chars :int :char :char]  ;; <-- here
;;              :emit [[:aload 0]
;;                     [:iload 1]
;;                     [:iload 2]
;;                     [:castore]
;;                     [:iload 2]
;;                     [:ireturn]]}]})

;; [(test.Klass/asetLiteral a 0 \b)
;;  (seq a)] 


;;Maybe speed boost!
;; ultrarand.bytecode>  (let [arr (char-array 1) i #primitive/int[0]] (c/quick-bench (my.pkg.Adder/asetLiteral arr i \b)))
;; Evaluation count : 154757250 in 6 samples of 25792875 calls.
;; Execution time mean : 2.060015 ns
;; Execution time std-deviation : 0.078509 ns
;; Execution time lower quantile : 1.981559 ns ( 2.5%)
;; Execution time upper quantile : 2.134735 ns (97.5%)
;; Overhead used : 1.805503 ns
;; nil
;; ultrarand.bytecode>  (let [arr (char-array 1) i #primitive/int[0]] (c/quick-bench (aset arr i \b)))
;; Evaluation count : 96000000 in 6 samples of 16000000 calls.
;; Execution time mean : 4.216589 ns
;; Execution time std-deviation : 0.163055 ns
;; Execution time lower quantile : 4.084754 ns ( 2.5%)
;; Execution time upper quantile : 4.421212 ns (97.5%)
;; Overhead used : 1.805503 ns
;; nil
