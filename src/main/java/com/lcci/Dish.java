package com.lcci;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Component;
import org.springframework.context.annotation.Scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;



@Configuration
public class Dish {
	public enum Type { MEAT, FISH, OTHER }

	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;

        @Autowired
        Message firstMessage;

	public Dish() {	
		this.name = "food";
		this.vegetarian = false;
		this.calories = 500;
		this.type = Type.MEAT;
	}


	public Dish(String name, boolean vegetarian, int calories, Type type) {	
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}
	
	public String getName() { return name;}
	public boolean isVegetarian() { return vegetarian; }
	public int getCalories() {return calories;}
	public Type getType() {return type;}


	// NOTE!!!!
	// default is singleton IF you use @Configuration on the bean
	// thus prototype is needed if you want one per call to getBean
        //
        // @Bean
        // @Scope("prototype")
        //
        @Bean
        public Info genInfo() {
          return new Info();
        }

        //@Bean(name = "vegiBean")
        //or
        // auto mapped to name of bean by default
        @Bean
        public Dish vegiBean() {
          return new Dish("grape", true, 20, Type.OTHER);
        }

 	//@Bean(name = "meatBean")
 	// or
 	// auto mapped to name of bean by default
 	@Bean
  	public Dish meatBean() {
      	  return new Dish();
  	}

        // example found by looking at getBean Spring doc directly not a video 
        //
        @Bean(name = "food") 
        @Scope(value  = "prototype")
        public Dish specialMeatDish(String meatName) {
          return new Dish(meatName, false, 100, Type.MEAT);
        }



	@Override
	public String toString() {
		return "Dish was [name=" + name + ", vegetarian=" + vegetarian
				+ ", calories=" + calories + ", type=" + type + "] with message:"+firstMessage.toString();
	}


}
