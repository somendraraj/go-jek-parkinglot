package com.gojek.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojek.common.Parameter;

public class ParkACarServiceTest {

	private ParkingLotService lotService;
	
	private ParkACarService service;

	@Before
	public void setUp() throws Exception {
		this.service = new ParkACarService();
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
		this.service.doAction(param);
	}

	@Test
	public void tesPakingFull() {
		Parameter param = new Parameter();
		param.setValue(new String[] { "park", "KA-01-HH-9999", "Blue" });
		this.service.doAction(param);
	}

}
