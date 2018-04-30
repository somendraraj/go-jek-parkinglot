package com.gojek.service;

import java.text.MessageFormat;

import com.gojek.common.Constants;
import com.gojek.common.Parameter;
import com.gojek.common.store.ParkingSpace;
import com.gojek.common.util.MapUpdateUtil;
import com.gojek.parkinglot.Car;

public class LeaveParkingService implements ParkingService {

	@Override
	public void doAction(Parameter param) {

		try {
			Integer slot = Integer.parseInt(param.getValue()[1]);
			Car car = ParkingSpace.getAvailableSlotList().get(slot - 1);

			if (car == null) {
				System.out.println(Constants.NOT_FOUND);
				return;
			}

			ParkingSpace.getAvailableSlotList().set(slot - 1, null);

			MapUpdateUtil.leaveCarFromParkingLot(car, slot);

			System.out.println(MessageFormat.format(Constants.SLOT_FREE, slot));

		} catch (NumberFormatException ex) {
			System.out.println(Constants.ERROR_INVALID_SPACE_NO);
			return;
		}

	}

}
