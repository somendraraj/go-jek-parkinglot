package com.gojek.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojek.common.Parameter;

public class ParkingStatusServiceTest {

	private ParkingStatusService parkingStatusService;

	private ParkACarService parkingService;
	
	private ParkingLotService lotService;

	@Before
	public void setUp() throws Exception {

		parkingService = new ParkACarService();

		parkingStatusService = new ParkingStatusService();
		
		lotService = new ParkingLotService();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoAction() {
		
		Parameter param = new Parameter();
		param.setValue(new String[] { "create_parking_lot", "6" });
		lotService.doAction(param);

		param.setValue(new String[] { "status" });
		parkingStatusService.doAction(param);

		param.setValue(new String[] { "park", "KA-01-HH-1234", "White" });
		parkingService.doAction(param);

		param.setValue(new String[] { "status" });
		parkingStatusService.doAction(param);

	}

}
