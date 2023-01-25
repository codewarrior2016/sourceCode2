package com.lcci;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import com.lcci.Dish;


// different possible values
// @Configuration
// @Component
@Configuration
public class BeanFactory{

	// NOTE!!!!
	// DEFAULT is singleton IF you use @Configuration on the bean
	// thus prototype is needed if you want one per call to getBean
	// default is singleton when using @Component also
        //
        // @Bean
        // @Scope("prototype")
        //
        @Bean
	@Scope("prototype")
        public Info genInfo() {
          return new Info();
        }

        //@Bean(name = "vegiBean")
        //or
        // auto mapped to name of method by default
        @Bean
        public Dish vegiBean() {
          return new Dish("grape", true, 20, Dish.Type.OTHER);
        }

 	//@Bean(name = "meatBean")
 	// or
 	// auto mapped to name of bean by default
 	@Bean(initMethod = "populateCache")
        @Scope("prototype")
  	public Dish meatBean() {
      	  return new Dish();
  	}

        // example found by looking at getBean Spring doc directly not a video 
        //
        @Bean(name = "food") 
        @Scope(value  = "prototype")
        public Dish specialMeatDish(String meatName) {
          return new Dish(meatName, false, 100, Dish.Type.MEAT);
        }

        @Bean(name = "dishWithTwoMessages")
	@Scope("prototype")
        public Dish dishWithSecondMessage() {
	  return new Dish(new Message("data for second message"));
        }

        // called after init on static OR on after EACH dynamic init
        public void populateCache() {
          System.err.println("POPULATE cache");
        }

	@Override
	public String toString() {
		return "BeanFactory";
        }
} 
