(ns server.machines.del
  (:use [server.utils :only [clj->js prn-js clj->json transform-keys prn]])
  (:require [server.vm :as vm]
            [server.http :as http]))

(defn handle [resource request response uuid]
  (vm/del
   uuid
   (fn [error]
     (if error
       (http/error response error)
       (http/ok response)))))