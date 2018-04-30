package com.gojek.service;

import com.gojek.common.Parameter;
import com.gojek.common.store.ParkingSearchMap;
import com.gojek.common.store.ParkingSpace;

public class RegistrationNoByColorService implements ParkingService {

	@Override
	public void doAction(Parameter param) {
		String color = param.getValue()[1];

		ParkingSearchMap.getColorLotMap().get(color).forEach(slot -> {
			System.out.println(ParkingSpace.getAvailableSlotList().get(slot).getRegNumber());
		});
	}

}
