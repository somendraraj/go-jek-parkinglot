package com.gojek.common;

import java.util.HashMap;
import java.util.Map;

import com.gojek.service.LeaveParkingService;
import com.gojek.service.ParkACarService;
import com.gojek.service.ParkingLotByColorService;
import com.gojek.service.ParkingLotByRegistrationNoService;
import com.gojek.service.ParkingLotService;
import com.gojek.service.ParkingService;
import com.gojek.service.ParkingStatusService;
import com.gojek.service.RegistrationNoByColorService;

/**
 * 
 * @author Somendra1.Raj
 *
 */
public class Cache {
	private static Map<String, ParkingService> commandMap;

	/**
	 * 
	 * @param action
	 * @param values
	 */
	public static void processRequest(String action, String[] values) {
		if (commandMap == null) {
			prepareCommandMap();
		}

		ParkingService service = commandMap.get(action);
		Parameter param = new Parameter();
		param.setValue(values);
		service.doAction(param);
	}
	
	

	/**
	 * insert data into command map
	 */
	public static void prepareCommandMap() {
		commandMap = new HashMap<>();
		
		commandMap.put("create_parking_lot", new ParkingLotService());
		commandMap.put("park", new ParkACarService());
		commandMap.put("leave", new LeaveParkingService());
		commandMap.put("status", new ParkingStatusService());
		commandMap.put("registration_numbers_for_cars_with_colour", new RegistrationNoByColorService());
		commandMap.put("slot_numbers_for_cars_with_colour", new ParkingLotByColorService());
		commandMap.put("slot_number_for_registration_number", new ParkingLotByRegistrationNoService());
	}

}
