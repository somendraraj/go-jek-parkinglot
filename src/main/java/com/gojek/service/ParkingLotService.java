package com.gojek.service;

import java.text.MessageFormat;

import com.gojek.common.Constants;
import com.gojek.common.Parameter;
import com.gojek.common.store.ParkingSearchMap;
import com.gojek.common.store.ParkingSpace;

public class ParkingLotService implements ParkingService {
	
	@Override
	public void doAction(Parameter param) throws NumberFormatException {
		try {

			Integer capacity = Integer.valueOf((String) param.getValue()[1]);
			ParkingSpace.createSlotList(capacity);
			ParkingSearchMap._initialize();
			System.out.println(MessageFormat.format(Constants.PARKING_LOT_CREATED, capacity));

		} catch (NumberFormatException e) {
			System.out.println(Constants.ERROR_PARKING_LOT);
		}

	}
	
}
