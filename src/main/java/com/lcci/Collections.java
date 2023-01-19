package com.lcci;

import java.util.*;

import java.util.function.Consumer;

//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.*;
//
//
import org.springframework.context.annotation.Bean;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.*;
import org.springframework.boot.web.servlet.context.*;

import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Collections {

// @Autowired
//  Dish dish;

  public static void main(String[] args) {

   ApplicationContext appContext = SpringApplication.run(Collections.class, args);

   System.err.println("Collections testing");

   Dish dish = appContext.getBean("meatBean", Dish.class);
   System.err.println(dish.toString());

   Info info = appContext.getBean(Info.class);
   System.err.println(info.toString());

   Dish vegiDish = appContext.getBean("vegiBean", Dish.class);
   System.err.println(vegiDish.toString());

   Dish glenDish = (Dish)appContext.getBean("food", "glen");  // Casting needed
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

   System.err.println(appContext.toString());

   //AnnotationConfigServletWebServerApplicationContext acswsaContext = (AnnotationConfigServletWebServerApplicationContext)appContext;
   //acswsaContext.close();


  }


}

