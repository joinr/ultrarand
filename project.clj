(defproject ultrarand "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [com.clojure-goes-fast/clj-java-decompiler "0.3.0"]
                 [insn                     "0.4.0"
                  :exclusions [org.ow2.asm/asm]]
                 [org.ow2.asm/asm          "7.1"]
                 [jise "0.1.0-SNAPSHOT"]]
  :java-source-paths ["java"])
