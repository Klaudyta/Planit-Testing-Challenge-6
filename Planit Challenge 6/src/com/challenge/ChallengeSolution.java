package com.challenge;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ChallengeSolution {
	
	static ArrayList<Person> peopleArrayList = buildPeopleArrayList();
	static ArrayList<Person> newArrayList = getListWithoutDuplicates(peopleArrayList);
	
	public static void main(String[] args) throws Exception {
	
		findDuplicateNames();
		
		System.out.println("LIST WITHOUT DUPLICATE NAMES");
		for (Person person : newArrayList) {
			System.out.println(person.getName());
		}
		System.out.println("\n");
		
		
		averageAge();
		findAge();
		findUniqueCountries();
	}
	
	public static ArrayList<Person> buildPeopleArrayList(){ // Method to build ArrayList with data from txt file
		ArrayList<Person> peopleArrayList = new ArrayList<>();
		
		try {
			FileReader reader = new FileReader ("ListPeople.txt");
			Scanner input = new Scanner(reader);
			
			while (input.hasNext() == true){
				String[] parts = input.nextLine().split(",");
				if(parts.length == 5) {
					Person newPerson	= new Person(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), parts[4]);
					peopleArrayList.add(newPerson);					
				}else {
					throw new IOException ();
				}
			}
			input.close();
			reader.close();
		 }
		 catch (IOException err){
			 System.out.println("Failed reading");
		 }
	return peopleArrayList;
	}
	
	public static void findDuplicateNames() { 
		
		Set<String> s = new HashSet<>();
		System.out.println("LIST OF DUPLICATE NAMES");
		for(Person person : peopleArrayList) {
			if(s.add(person.getName()) == false)
				System.out.println(person.getName());
		}
		System.out.println("\n");
	}
		
	public static ArrayList<Person> getListWithoutDuplicates(ArrayList<Person> peopleArrayList){
		
		Set<Person> personSet = new TreeSet<Person>(new PersonComparator());
		for (Person person : peopleArrayList) {
			personSet.add(person);
		}
		
		ArrayList<Person> newArrayList = new ArrayList<Person>(personSet);
		return newArrayList;
	}
	
	public static int averageAge() {
		int sumAge = 0;
		int avgAge = 0;		
		
		for (Person person : newArrayList) {
			sumAge += person.getAge();
		}
		avgAge = sumAge / newArrayList.size();
		System.out.println("AVERAGE AGE: " + avgAge + "\n");
		
		return avgAge; 
	}
	
	public static void findAge() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter the maximun age: ");
		int maxAge = sc.nextInt();
		System.out.println("LIST OF PEOPLE YOUNGER THAN " + maxAge + " YEARS OLD: ");
		for (Person person : newArrayList) {
			if(person.getAge() < maxAge) {
				System.out.println(person.getName() + " " + "Age: " + person.getAge() + " " + "Country: " + person.getCountry());
			}	
		}
	}
	
	public static void findUniqueCountries() {
		HashMap<String, Integer> mp = new HashMap<String, Integer>();
		
		System.out.println("\nLIST OF UNIQUE COUNTRIES");
		for(Person person : newArrayList) {
			if(mp.containsKey(person.getCountry())) {
				mp.put(person.getCountry(), mp.get(person.getCountry() + 1));
			}else {
				mp.put(person.getCountry(), 1);
			}
		}
		for (Map.Entry entry : mp.entrySet()){
			if(entry.getValue() != null) {
				System.out.println(entry.getKey() + " ");
			}	
		}
		
	}
	
}
		
	
		