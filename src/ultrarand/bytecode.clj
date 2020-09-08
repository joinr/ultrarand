(ns ultrarand.bytecode
  (:require [insn.core :as insn]
            [insn.op :as op]))

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

(def class-data
  {:name    'my.pkg.Adder
   :flags  #{:public}
   :fields  []
   :methods [{:flags #{:public :static}, :name "asetLiteral", :desc [chars :int :char]
              :emit [[:aload 0]
                     [:iload 1]
                     [:iload 2]
                     [:castore]
                     [:iload 2]
                     [:ireturn]]}]})

(def class-object (insn/define class-data))
(def obj (-> class-object .newInstance))

(def class-data2
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
