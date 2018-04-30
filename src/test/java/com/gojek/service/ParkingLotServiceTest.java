package com.gojek.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojek.common.Parameter;
import com.gojek.common.store.ParkingSpace;
import com.gojek.parkinglot.Car;

public class ParkingLotServiceTest {

	private ParkingLotService service;

	@Before
	public void setUp() throws Exception {
		service = new ParkingLotService();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoAction() {
		int maxSize = 6;
		Parameter param = new Parameter();
		param.setValue(new String[] { "create_parking_lot", "6" });
		service.doAction(param);
		List<Car> availablity = ParkingSpace.getAvailableSlotList();
		assertTrue(availablity.size() == maxSize);

	}

}
