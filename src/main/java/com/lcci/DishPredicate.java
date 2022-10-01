 
package com.lcci;

// good Code
//
//
@FunctionalInterface
public interface DishPredicate {
	public Boolean test(Dish d);
	default void doWork() { System.err.println("working "); }
	
}
