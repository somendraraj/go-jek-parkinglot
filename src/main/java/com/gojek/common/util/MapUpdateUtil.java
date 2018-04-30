package com.gojek.common.util;

import java.util.ArrayList;
import java.util.List;

import com.gojek.common.store.ParkingSearchMap;
import com.gojek.parkinglot.Car;
/**
 * 
 * @author Somendra1.Raj
 *
 */
public class MapUpdateUtil {

	/**
	 * this method will add the car into parking lot, as well as upadte the
	 * ParkingSearchMap
	 * 
	 * @param car
	 * @param firstAvaiableSlot
	 */
	public static void addCarToParkingLot(Car car, Integer firstAvaiableSlot) {
		ParkingSearchMap.getSlotRegistrationNoMap().put(car.getRegNumber(), firstAvaiableSlot);

		List<Integer> parkingLots = ParkingSearchMap.getColorLotMap().get(car.getColor());
		if (parkingLots == null) {
			parkingLots = new ArrayList<>();
		}
		parkingLots.add(firstAvaiableSlot);
		ParkingSearchMap.getColorLotMap().put(car.getColor(), parkingLots);
	}
	
	
	

	/**
	 * this method will leave the car from parking lot, and update the parking
	 * search map
	 * 
	 * @param car
	 * @param slot
	 */
	public static void leaveCarFromParkingLot(Car car, Integer slot) {

		ParkingSearchMap.getSlotRegistrationNoMap().remove(car.getRegNumber());
		ParkingSearchMap.getColorLotMap().get(car.getColor()).remove(slot);
	}
}
