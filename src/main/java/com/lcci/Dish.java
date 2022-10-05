package com.lcci;

import org.springframework.stereotype.*;

@Component
public class Dish {
	public enum Type { MEAT, FISH, OTHER }

	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;

        //used by spring boot
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
	
	@Override
	public String toString() {
		return "Dish was [name=" + name + ", vegetarian=" + vegetarian
				+ ", calories=" + calories + ", type=" + type + "]";
	}
 

}
