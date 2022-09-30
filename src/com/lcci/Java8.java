package com.lcci;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.Comparator; //java.util.Comparator.comparing

import com.lcci.*;


import static java.util.stream.Collectors.toList;

public class Java8 {

	
	public static void main(String[] strgv) {

		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH) );
		
		Dish x100 = menu.get(0);
		System.err.println(x100.toString());
		
		List<Dish> heavyDishes = menu.stream()
				.filter(d -> d.getCalories() > 300)
				.skip(2)
				.collect(toList());
		
		
		heavyDishes.stream().forEach(d -> System.out.println(d));
		System.out.println(heavyDishes.toString());
		if (heavyDishes instanceof java.util.LinkedList) { System.err.println("is linked List"); }
		
		
		System.out.println("-----A");
		Dish greatest = menu.stream()
				      .reduce(menu.get(0), (a, b)-> (a.getCalories() > b.getCalories() ? a : b));
		
		Optional<Dish> greatest2 = menu.stream()
			      .reduce((a, b)-> (a.getCalories() > b.getCalories() ? a : b));

		Dish greatest3 = menu.stream()
			      .reduce((a, b)-> (a.getCalories() > b.getCalories() ? a : b)).get();

		System.out.println("-----B");
		
		{
			List<Dish> dishes = menu.stream()
				.filter(d -> d.isVegetarian())
				.collect(toList());
		
			dishes.stream().forEach(d -> System.out.println(d));
		}
		
		System.out.println("-----");
		
		{
			List<String> dishes = menu.stream()
				.filter(d -> d.isVegetarian())
				.map(d -> d.getName())
				.map(d -> d + ": "+d.length())
				.collect(toList());
		
			dishes.stream().forEach(d -> System.out.println(d));
		}
        
		System.out.println("-----");
		
		String[] arrayOfWords = {"Goodbye", "World"};
		
		StringBuffer sb = new StringBuffer();
		for(String x: arrayOfWords) { sb.append(x); }
		
		Stream<String> ss = Stream.of(sb.toString());
		
		List<String> chars = ss
				 .map(d -> d.split(""))
				 .flatMap(Arrays::stream)
				 .distinct()
				 .collect(toList());
		
		chars.stream().forEach(d -> System.out.println(d));
		
		System.out.println("-----");
		int totalCal = menu.stream()
				.map(d -> d.getCalories())
				.reduce(0, (a,b) -> a+b);
		
		System.out.println("total is:"+totalCal);
	
		System.out.println("-----X1");
		
		List<Dish> dishList1 = filterDish(menu, d -> d.isVegetarian());
		dishList1.stream().forEach(d -> System.out.println(d));
		
		System.out.println("-----X2");

		String gw = "Goodbye World";
		Stream<String> gws = Stream.of(gw);
		List<String> theChars = gws
				 .map(d -> d.split(""))
				 .flatMap(Arrays::stream)
				 .distinct()
				 .collect(toList());
		
		theChars.stream().forEach(d -> System.out.println(d));
	}
	
	static public List<Dish> filterDish(List<Dish> theList, DishPredicate d1) {
		List<Dish> resultList= new LinkedList<Dish>();
		for(Dish dish : theList) {
			if (d1.test(dish)) resultList.add(dish);
		}
		return resultList;

	}
	
	
}
