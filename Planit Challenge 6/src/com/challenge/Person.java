package com.challenge;

import java.time.LocalDate;
import java.time.Period;

public class Person {
	
	private String name;
	private int year;
	private int month;
	private int day;
	private int age;
	private String country;
	
	public Person () {
		name 	= "";
		year	= 0;
		month	= 0;
		day		= 0;
		country	= "";
	}
	
	public Person (String pName, int pYear, int pMonth, int pDay, String pCountry) {
		name 	= pName;
		year	= pYear;
		month	= pMonth;
		day		= pDay;
		country	= pCountry;
	}
	
	public void setName( String pName) {
		name	= pName;
	}
	
	public void setYear( int pYear) {
		year	= pYear;
	}
	
	public void setMonth( int pMonth) {
		month	= pMonth;
	}
	
	public void setDay( int pDay) {
		day	= pDay;
	}
	
	public void setAge( int pAge) {
		age = pAge;
	}
	
	public void setCountry(String pCountry) {
		country	= pCountry;
	}
	
	public String getName() {
		return name;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getAge() {
		
		LocalDate dob = LocalDate.of(getYear(), getMonth(), getDay());
		LocalDate now = LocalDate.now();
		Period period = Period.between(dob, now);
		
		return period.getYears(); 
	}
	
	public String getCountry() {
		return country;
	}
}
