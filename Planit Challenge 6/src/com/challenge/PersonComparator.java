package com.challenge;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person>{
	
	@Override	
	public int compare(Person p1, Person p2) {
		
		int m = p1.getName().compareToIgnoreCase(p2.getName());
		
		if (m != 0) {
			return m;
		}
		return m;
		
	}

}
