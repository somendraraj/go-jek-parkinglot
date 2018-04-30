package com.gojek.common.store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.gojek.parkinglot.Car;

public class ParkingSpace {

	private static List<Car> availableSlotList;
	
	/**
	 * 
	 * @param maxSize
	 * @return
	 */
	public static List<Car> createSlotList(Integer maxSize) {

		if (availableSlotList == null) {
			synchronized (ParkingSpace.class) {
				if (availableSlotList == null) {
					availableSlotList = new ArrayList<Car>(Collections.nCopies(maxSize, null));
				}
			}
		}
		return availableSlotList;
	}
	
	/**
	 * This method will return available list of slots 
	 * @return
	 */
	public static List<Car> getAvailableSlotList() {
		return availableSlotList;
	}
}
