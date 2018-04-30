package com.gojek.service;

import com.gojek.common.Constants;
import com.gojek.common.Parameter;
import com.gojek.common.store.ParkingSearchMap;

public class ParkingLotByRegistrationNoService implements ParkingService {

	@Override
	public void doAction(Parameter param) {

		String registrationNo = param.getValue()[1];
		Integer result = ParkingSearchMap.getSlotRegistrationNoMap().get(registrationNo);

		if (result == null) {
			System.out.println(Constants.NOT_FOUND);
		} else {
			System.out.println(result+1);
		}

	}

}
