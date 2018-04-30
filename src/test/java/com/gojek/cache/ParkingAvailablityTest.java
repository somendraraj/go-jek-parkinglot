package com.gojek.cache;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojek.common.store.ParkingSpace;
import com.gojek.parkinglot.Car;

public class ParkingAvailablityTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateSlotList() {
		int maxSize = 6;
		List<Car> availablity = ParkingSpace.createSlotList(maxSize);
		assertTrue(availablity.size() == maxSize);
	}

	@Test
	public void testGetAvailableSlotList() {
		int maxSize = 6;
		List<Car> availablity = ParkingSpace.getAvailableSlotList();
		assertTrue(availablity.size() == maxSize);
	}

}
