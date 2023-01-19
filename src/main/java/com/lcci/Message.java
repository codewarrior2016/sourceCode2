package com.lcci;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;



@Component
public class Message {

   private static String message = "default message";

   public Message() {
   }

   public Message(String defaultMessage) {
     this.message=defaultMessage;
   }


   public String toString() {
     return ("Data is :"+message);
   }


}

