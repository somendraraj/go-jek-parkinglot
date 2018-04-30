package com.gojek.service;

import java.util.stream.IntStream;

import com.gojek.common.Parameter;
import com.gojek.common.store.ParkingSearchMap;
import com.gojek.common.store.ParkingSpace;
import com.gojek.parkinglot.Car;


public class ParkingStatusService implements ParkingService {

	@Override
	public void doAction(Parameter param) {
		if (ParkingSearchMap.getSlotRegistrationNoMap().isEmpty()) {
			System.out.println("Parking lot is empty");
			return;
		}

		System.out.println("Lot No" + "    " + "Registration No" + "    " + "Color");

		IntStream.range(0, ParkingSpace.getAvailableSlotList().size()).forEach(i -> {
			Car car = ParkingSpace.getAvailableSlotList().get(i);
			if (car != null) {
				int j = i + 1;
				StringBuilder sb = new StringBuilder();
				sb.append("   ");
				sb.append(j);
				sb.append("      ");
				sb.append(car.getRegNumber());
				sb.append("      ");
				sb.append(car.getColor());
				System.out.println(sb.toString());
			}
		});
	}

}
