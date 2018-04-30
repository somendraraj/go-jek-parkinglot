package com.gojek.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojek.common.Parameter;

public class LeaveParkingServiceTest {

	LeaveParkingService leaveParkingService;

	private ParkACarService parkingService;

	private ParkingLotService service;

	@Before
	public void setUp() throws Exception {
		this.leaveParkingService = new LeaveParkingService();
		this.parkingService = new ParkACarService();
		this.service = new ParkingLotService();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoAction() {

		Parameter param = new Parameter();
		param.setValue(new String[] { "create_parking_lot", "6" });
		this.service.doAction(param);

		param.setValue(new String[] { "park", "KA-01-HH-1234", "White" });
		this.parkingService.doAction(param);

		param.setValue(new String[] { "leave", "1" });
		this.leaveParkingService.doAction(param);

	}

}
