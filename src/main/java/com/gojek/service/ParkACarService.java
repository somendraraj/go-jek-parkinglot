package com.gojek.service;

import java.text.MessageFormat;

import com.gojek.common.Constants;
import com.gojek.common.Parameter;
import com.gojek.common.store.ParkingSpace;
import com.gojek.common.util.MapUpdateUtil;
import com.gojek.parkinglot.Car;

public class ParkACarService implements ParkingService {

	@Override
	public void doAction(Parameter param) {
		Integer firstAvaiableSlot = getFirstEmptySlot();

		if (firstAvaiableSlot == null) {
			System.out.println(Constants.PARKING_FULL);
			return;
		}

		Car car = new Car(param.getValue()[1], param.getValue()[2]);
		MapUpdateUtil.addCarToParkingLot(car, firstAvaiableSlot);

		ParkingSpace.getAvailableSlotList().set(firstAvaiableSlot, car);
		System.out.println(
				MessageFormat.format(Constants.PARKING_SPACE_BLOCKED, firstAvaiableSlot + 1, car.getRegNumber()));
	}

	private Integer getFirstEmptySlot() {
		for (int slot = 0; slot < ParkingSpace.getAvailableSlotList().size(); slot++) {
			if (ParkingSpace.getAvailableSlotList().get(slot) == null) {
				return slot;
			}
		}
		return null;
	}
}
