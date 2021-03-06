package gasfilling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Gas Station Filling Tests - Two Cars in the Queue with 3 Stations available to fill Gas ")
public class GasStationFillingForTwoCarsTest {

	@DisplayName("{2,2},2,1,3 = 2 ;;; Three Gas Stations Can parallely fill up two cars with same capacity")
	@org.junit.jupiter.api.Test
	public void testThreeStationsTwoCarsSameCapacitySameTimeFilling() {
		GasFilling gasStation = new GasFilling();
		int[] source = new int[] { 2, 2 };

		Assertions.assertEquals(gasStation.solution(source, 2, 1, 3), 2);
	}

	@DisplayName("{5,2},2,1,3 = -1 ;;; First Car with 5 liter fuel capacity cannot be filled at any gas station since their availability is lower")
	@org.junit.jupiter.api.Test
	public void testThreeStationsFirstCarHigherCapacity() {
		GasFilling gasStation = new GasFilling();
		int[] source = new int[] { 5, 2 };

		Assertions.assertEquals(gasStation.solution(source, 2, 1, 3), -1);
	}

	@DisplayName("{2,5},1,2,3 = -1 ;;; First Car can get filled but Second car has capacity that cannot be filled at any station")
	@org.junit.jupiter.api.Test
	public void testThreeStationsOneCarFilledAtZ() {
		GasFilling gasStation = new GasFilling();
		int[] source = new int[] { 2, 5 };

		Assertions.assertEquals(gasStation.solution(source, 1, 2, 3), -1);
	}

	@DisplayName("{2,2},4,1,1 = 4 ;;;  All Cars with same Capacity can only be filled at one station though other stations are free but their fuel availability is lower than car in queue fuel capacity")
	@org.junit.jupiter.api.Test
	public void testThreeStationsAllCarsFilledAtOneStation() {
		GasFilling gasStation = new GasFilling();
		int[] source = new int[] { 2, 2 };

		Assertions.assertEquals(gasStation.solution(source, 4, 1, 1), 4);
	}

	@DisplayName("{3,2},1,1,6 = 5 ;;;  All Cars with varying capacity can only be filled at one station (last station) while other stations are free but less availability")
	@org.junit.jupiter.api.Test
	public void testThreeStationsEmptyCannotFill() {
		GasFilling gasStation = new GasFilling();
		int[] source = new int[] { 3, 2 };

		Assertions.assertEquals(gasStation.solution(source, 1, 1, 6), 5);
	}

	@DisplayName("{3,2},5,4,6 = 3 ;;;  All Gas Stations have enough capacity so all cars can fill up in parallel in any gas station")
	@org.junit.jupiter.api.Test
	public void testThreeStationsWithHighestCapacity() {
		GasFilling gasStation = new GasFilling();
		int[] source = new int[] { 3, 2 };

		Assertions.assertEquals(gasStation.solution(source, 5, 4, 6), 3);
	}

	@DisplayName("{3,2},2,0,3 = 3 ;;;  Gas Stations have exact Capacity, One Gas station has no gas, First car needs fill at last Station")
	@org.junit.jupiter.api.Test
	public void testThreeStationsWithExactCapacity() {
		GasFilling gasStation = new GasFilling();
		int[] source = new int[] { 3, 2 };

		Assertions.assertEquals(gasStation.solution(source, 2, 0, 3), 3);
	}

	@DisplayName("{3,2},0,0,0 = -1 ;;;  None of the Gas stations have Gas to begin with")
	@org.junit.jupiter.api.Test
	public void testThreeStationsWithNoGas() {
		GasFilling gasStation = new GasFilling();
		int[] source = new int[] { 3, 2 };

		Assertions.assertEquals(gasStation.solution(source, 0, 0, 0), -1);
	}

	@DisplayName("{5,5},5,5,5 = 5 ;;;  All Gas Stations have same Capacity as that of both cars, cars should get filled in parallel and be done")
	@org.junit.jupiter.api.Test
	public void testThreeStationsSameCapacityAsTwoCars() {
		GasFilling gasStation = new GasFilling();
		int[] source = new int[] { 5, 5 };

		Assertions.assertEquals(gasStation.solution(source, 5, 5, 5), 5);
	}
}
