package com.bridgelabz.birdsanctuary;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.stream.Stream;


import java.util.stream.Collectors;
import java.util.ArrayList;

public class BirdSanctuaryManager implements Flyable,Swimmable  {
	static BirdSanctuaryManager instance;
	
	Set<Birds> birdList = new HashSet<Birds>();
	
	private BirdSanctuaryManager() {
	
	}
	
	static synchronized BirdSanctuaryManager getInstance() {
		if(instance == null) {
			instance = new BirdSanctuaryManager();
		}
		return instance;
	}
	
	public void add(Birds bird) throws BirdSanctuaryException {
		if(bird == null) {
        	throw new BirdSanctuaryException();
        }
		else if(birdList.add(bird)) {
			bird.incrementCount();
			bird.totalCount++;
	    }
	}
	
	public void remove(Birds bird) {
		if(birdList.remove(bird)) {
			bird.decrementCount();
		}
	}
	
	public void print() {
		for(Birds list: birdList) {
			System.out.println(list);
		}
	}
	
	public void printEatables() {
		birdList.stream().forEach(bird -> bird.eat());
	}
	
	public void printFlyables() {
		birdList.stream().filter(bird -> bird instanceof Flyable).
		forEach(bird -> ((Flyable)bird).fly());
//		birdList.stream().filter(bird -> bird instanceof Flyable).collect(Collectors.toList())
//		.forEach(bird -> ((Flyable)bird).fly());
	}
	
	public void printSwimable() {
		birdList.stream().filter(bird -> bird instanceof Swimmable).
		forEach(bird -> ((Swimmable)bird).swim());
//		birdList.stream().filter(bird -> bird instanceof Swimmable)
//		.map(bird -> (Swimmable)bird).forEach(bird -> bird.swim());
	}

	@Override
	public void swim() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}


}
	
	