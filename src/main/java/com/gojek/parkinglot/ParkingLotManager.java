package com.gojek.parkinglot;

/**
 * 
 * @author Somendra1.Raj
 *
 */
public class ParkingLotManager implements ParkingLot {
	private long spaceId;

	public ParkingLotManager() {

	}

	@Override
	public Long getSpaceId() {
		return spaceId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + spaceId);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParkingLotManager other = (ParkingLotManager) obj;
		if (spaceId != other.spaceId)
			return false;
		return true;
	}
}
