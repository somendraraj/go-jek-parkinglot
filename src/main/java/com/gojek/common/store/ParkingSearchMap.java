package com.gojek.common.store;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Somendra1.Raj
 *
 */
public class ParkingSearchMap {

	private static Map<String, Integer> slotRegistrationNumberMap;
	private static Map<String, List<Integer>> colorLotMap;
	
	/**
	 * this method will initialize the slotRegistrationNumberMap and colorLotMap
	 */
	public static void _initialize() {

		if (slotRegistrationNumberMap == null) {
			synchronized (ParkingSpace.class) {
				if (slotRegistrationNumberMap == null) {
					slotRegistrationNumberMap = new HashMap<String, Integer>();
					colorLotMap = new HashMap<>();
				}
			}
		}
	}
	
	/**
	 * this method will return registration number based cars
	 *  
	 * @return
	 */
	public static Map<String, Integer> getSlotRegistrationNoMap() {
		if (slotRegistrationNumberMap == null) {
			_initialize();
		}
		return slotRegistrationNumberMap;
	}

	/**
	 * this method will return colored cars map
	 * @return
	 */
	public static Map<String, List<Integer>> getColorLotMap() {
		if (colorLotMap == null) {
			_initialize();
		}
		return colorLotMap;
	}

}
