package com.gojek.service;

import com.gojek.common.Parameter;
import com.gojek.common.store.ParkingSearchMap;

public class ParkingLotByColorService implements ParkingService {

	@Override
	public void doAction(Parameter param) {
		String color = param.getValue()[1];
		ParkingSearchMap.getColorLotMap().get(color).forEach(value -> {
			System.out.println(value + 1);
		});
	}

}
