package com.gojek.parkinglot;

/**
 * Car class having properties registration number and color.
 * 
 * @author Somendra1.Raj
 *
 */
public class Car implements Vehicle {

	private String regNumber;
	private String color;

	/**
	 * Parameterize constructor
	 * 
	 * @param regNumber
	 * @param color
	 */
	public Car(String regNumber, String color) {
		this.regNumber = regNumber;
		this.color = color;
	}
	
	@Override
	public String getRegNumber() {
		return regNumber;
	}
	
	
	@Override
	public String getColor() {
		return color;
	}
	
	

}
