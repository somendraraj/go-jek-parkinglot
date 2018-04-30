package com.gojek.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojek.common.Parameter;


public class ParkingLotByColorServiceTest {

	private ParkingLotByColorService service;

	private ParkACarService parkingService;
	
	private ParkingLotService lotService;

	@Before
	public void setUp() throws Exception {
		this.parkingService = new ParkACarService();
		this.service = new ParkingLotByColorService();
		this.lotService = new ParkingLotService();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoAction() {
		
		Parameter param = new Parameter();
		param.setValue(new String[] { "create_parking_lot", "6" });
		this.lotService.doAction(param);

		param.setValue(new String[] { "park", "KA-01-HH-1234", "White" });
		this.parkingService.doAction(param);

		param.setValue(new String[] { "slot_numbers_for_cars_with_colour", "White" });
		this.service.doAction(param);
	}

}
