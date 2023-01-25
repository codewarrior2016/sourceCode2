package com.lcci;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;


// can use Component("name") default is LOWER message not Message if name no set
@Component
public class Message {

   private static String message = "default message";

   public Message() {
   }

   public Message(String defaultMessage) {
     this.message=defaultMessage;
   }


   public String toString() {
     return (message);
   }

}
