package com.lcci;

import java.util.*;

import java.util.function.Consumer;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
//import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class Collections {



  public static void main(String[] args) {

   System.err.println("Collections testing");

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


  }



}

