package com.lcci;

import java.util.*;

import java.util.function.Consumer;

//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.*;
//
//
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;


import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.*;
import org.springframework.boot.web.servlet.context.*;

import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Collections {


  public static void main(String[] args) {
   ApplicationContext appContext = SpringApplication.run(Collections.class, args);
   System.err.println("Collections testing");

   Dish meatDish = appContext.getBean("meatBean", Dish.class);
   System.err.println(meatDish.toString());

   Dish meatDish2 = appContext.getBean("meatBean", Dish.class);
   System.err.println(meatDish2.toString());

   Info info1 = appContext.getBean(Info.class); // ref by class
   info1.setMessage("updated message");
   System.err.println("info1 data: " + info1);

   Info info2 = appContext.getBean(Info.class);
   System.err.println("info2 data: " + info2); // will show update from above if singleton is mode

   Info info3 = appContext.getBean("genInfo",Info.class); // ref by name
   info3.setMessage("updated message2");
   System.err.println("info3 data: " + info3);

   Info info4 = (Info)appContext.getBean("genInfo"); // ref by name, but NO class type, so cast needed
   System.err.println("info4 data: " + info4);


   Dish vegiDish = appContext.getBean("vegiBean", Dish.class);
   System.err.println(vegiDish.toString());

   Dish glenDish = (Dish)appContext.getBean("food", "glenMeat");  // Casting needed, contructor arg used
   System.err.println(glenDish.toString());

   //System.err.println("all beans");
   //System.err.println(Arrays.asList(appContext.getBeanDefinitionNames()));

   List<String> dataList = new ArrayList<String>();

   dataList.add("info 0");
   dataList.add("info 1");
   dataList.add("info 2");
   dataList.add("info 3");
   dataList.add("info 4");
   dataList.add("info 5");

   System.err.println(dataList.size());
   System.err.println(dataList.get(3));

   System.err.println("checkout 1");
 
   Consumer<String> printer= s ->  System.out.println(s);

   dataList.forEach(printer);

   System.err.println(appContext.toString()+"\n");

   Message message1 = (Message)appContext.getBean(Message.class);
   System.err.println(message1);


   // needed to exit the program, stopping service [TOMCAT]
   AnnotationConfigServletWebServerApplicationContext acswsaContext = (AnnotationConfigServletWebServerApplicationContext)appContext;
   acswsaContext.close();

  }


}
