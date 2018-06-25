package gasstationfilling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import gasfilling.GasStationFillingGeneric;

@DisplayName("Gas Station Filling Tests - Three Cars in the Queue with 3 Stations available to fill Gas ")
public class GasStationFillingXThreeCarsTest {

	@DisplayName("{2,2,2},2,3,3 = 2 ;;; Three Gas Stations Can parallely fill up three cars with same capacity")
	@org.junit.jupiter.api.Test
	public void testThreeStationsThreeCarsSameCapacitySameTimeFilling() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 2, 2, 2 };

		Assertions.assertEquals(gasStation.solution(source, 2, 3, 3), 2);
	}

	@DisplayName("{5,2,2},2,1,3 = -1 ;;; First Car with 5 liter fuel capacity cannot be filled at any gas station since their availability is lower")
	@org.junit.jupiter.api.Test
	public void testThreeStationsFirstCarHigherCapacity() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 5, 2, 2 };

		Assertions.assertEquals(gasStation.solution(source, 2, 1, 3), -1);
	}

	@DisplayName("{2,5,2},1,2,3 = -1 ;;; First Car can get filled but Second car has capacity that cannot be filled at any station")
	@org.junit.jupiter.api.Test
	public void testThreeStationsOneCarFilledAtY() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 2, 5, 2 };

		Assertions.assertEquals(gasStation.solution(source, 1, 2, 3), -1);
	}

	@DisplayName("{2,2,2},6,1,1 = 6 ;;;  All Cars with same Capacity can only be filled at one station though other stations are free but their fuel availability is lower than car in queue fuel capacity")
	@org.junit.jupiter.api.Test
	public void testThreeStationsAllCarsFilledAtOneStation() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 2, 2, 2 };

		Assertions.assertEquals(gasStation.solution(source, 6, 1, 1), 6);
	}

	@DisplayName("{3,4,2},1,1,9 = 9 ;;;  All Cars with varying capacity can only be filled at one station (last station) while other stations are free but less availability")
	@org.junit.jupiter.api.Test
	public void testThreeStationsEmptyCannotFill() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 3, 4, 2 };

		Assertions.assertEquals(gasStation.solution(source, 1, 1, 9), 9);
	}

	@DisplayName("{3,2,4},5,4,6 = 4 ;;;  All Gas Stations have enough capacity so all cars can fill up in parallel in any gas station")
	@org.junit.jupiter.api.Test
	public void testThreeStationsWithHighestCapacity() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 3, 2, 4 };

		Assertions.assertEquals(gasStation.solution(source, 5, 4, 6), 4);
	}

	@DisplayName("{3,2,5},0,5,7 = 7 ;;;  Gas Stations have exact Capacity, X Gas station has no gas, three cars need filled at Y, Z Stations")
	@org.junit.jupiter.api.Test
	public void testThreeStationsXEmpty() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 3, 2, 5 };

		Assertions.assertEquals(gasStation.solution(source, 0, 5, 7), 7);
	}

	@DisplayName("{3,2,5},5,0,7 = 7 ;;;  Gas Stations have exact Capacity, Y Gas station has no gas, three cars need filled at X, Z Stations")
	@org.junit.jupiter.api.Test
	public void testThreeStationsYEmpty() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 3, 2, 5 };

		Assertions.assertEquals(gasStation.solution(source, 5, 0, 7), 7);
	}

	@DisplayName("{3,2,5},5,7,0 = 7 ;;;  Gas Stations have exact Capacity, Z Gas station has no gas, three cars need filled at X, Y Stations")
	@org.junit.jupiter.api.Test
	public void testThreeStationsZEmpty() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 3, 2, 5 };

		Assertions.assertEquals(gasStation.solution(source, 5, 7, 0), 7);
	}

	@DisplayName("{3,2,1},5,7,0 = 3 ;;;  Z Gas station has no gas, three cars need filled at X, Y Stations, third car needs to be filled at same time as second car")
	@org.junit.jupiter.api.Test
	public void testThreeStationsFirstCarHighestCapacity() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 3, 2, 1 };

		Assertions.assertEquals(gasStation.solution(source, 5, 7, 0), 3);
	}

	@DisplayName("{3,2,1},0,5,7 = 3 ;;;  X Gas station has no gas, three cars need filled at Y, Z Stations, third car needs to be filled at same time as second car")
	@org.junit.jupiter.api.Test
	public void testThreeStationsFillAtYZ() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 3, 2, 1 };

		Assertions.assertEquals(gasStation.solution(source, 0, 5, 7), 3);
	}

	@DisplayName("{3,2,5},0,5,7 = 7 ;;;  X Gas station has no gas, three cars need filled at Y, Z Stations, third car needs to be filled at different time as second car")
	@org.junit.jupiter.api.Test
	public void testThreeStationsFillAtYZAtDiffTime() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 3, 2, 5 };

		Assertions.assertEquals(gasStation.solution(source, 0, 5, 7), 7);
	}

	@DisplayName("{3,2,1},5,0,7 = 3 ;;;  Y Gas station has no gas, three cars need filled at X, Z Stations, third car needs to be filled at same time as second car")
	@org.junit.jupiter.api.Test
	public void testThreeStationsFillAtXZ() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 3, 2, 1 };

		Assertions.assertEquals(gasStation.solution(source, 5, 0, 7), 3);
	}

	@DisplayName("{3,2,5},5,0,7 = 7 ;;;  Y Gas station has no gas, three cars need filled at X, Z Stations, third car needs to be filled at different time as second car")
	@org.junit.jupiter.api.Test
	public void testThreeStationsFillAtXZAtDiffTime() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 3, 2, 5 };

		Assertions.assertEquals(gasStation.solution(source, 5, 0, 7), 7);
	}

	@DisplayName("{3,2,2},0,0,0 = -1 ;;;  None of the Gas stations have Gas to begin with")
	@org.junit.jupiter.api.Test
	public void testThreeStationsWithNoGas() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 3, 2, 2 };

		Assertions.assertEquals(gasStation.solution(source, 0, 0, 0), -1);
	}

	@DisplayName("{5,5,5},5,5,5 = 5 ;;;  All Gas Stations have same Capacity as that of cars, cars should get filled in parallel and be done")
	@org.junit.jupiter.api.Test
	public void testThreeStationsSameCapacityAsTwoCars() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 5, 5, 5 };

		Assertions.assertEquals(gasStation.solution(source, 5, 5, 5), 5);
	}

	@DisplayName("{1,1,1},3,0,0 = 3 ;;;  All Cars have same Capacity, Y, Z Stations have no Gas. cars should get filled in sequentially at station X")
	@org.junit.jupiter.api.Test
	public void testThreeStationsFilledAtX() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 1, 1, 1 };

		Assertions.assertEquals(gasStation.solution(source, 3, 0, 0), 3);
	}

	@DisplayName("{1,1,1},0,3,0 = 3 ;;;  All Cars have same Capacity, X, Z Stations have no Gas. cars should get filled in sequentially at station X")
	@org.junit.jupiter.api.Test
	public void testThreeStationsFilledAtY() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 1, 1, 1 };

		Assertions.assertEquals(gasStation.solution(source, 0, 3, 0), 3);
	}

	@DisplayName("{1,1,1},0,0,3 = 3 ;;;  All Cars have same Capacity, X, Y Stations have no Gas. cars should get filled in sequentially at station X")
	@org.junit.jupiter.api.Test
	public void testThreeStationsFilledAtZ() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 1, 1, 1 };

		Assertions.assertEquals(gasStation.solution(source, 0, 0, 3), 3);
	}

	@DisplayName("{1,2,3},6,0,0 = 6 ;;;  Cars have Varying Capacity, Y, Z Stations have no Gas. cars should get filled in sequentially at station X")
	@org.junit.jupiter.api.Test
	public void testThreeStationsFilledAtXVaryingCapacity() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 1, 2, 3 };

		Assertions.assertEquals(gasStation.solution(source, 6, 0, 0), 6);
	}

	@DisplayName("{1,2,3},0,6,0 = 6 ;;;  Cars have Varying Capacity, X, Z Stations have no Gas. cars should get filled in sequentially at station X")
	@org.junit.jupiter.api.Test
	public void testThreeStationsFilledAtYVaryingCapacity() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 1, 2, 3 };

		Assertions.assertEquals(gasStation.solution(source, 0, 6, 0), 6);
	}

	@DisplayName("{1,2,3},0,0,6 = 6 ;;;  Cars have Varying Capacity, X, Y Stations have no Gas. cars should get filled in sequentially at station X")
	@org.junit.jupiter.api.Test
	public void testThreeStationsFilledAtZVaryingCapacity() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 1, 2, 3 };

		Assertions.assertEquals(gasStation.solution(source, 0, 0, 6), 6);
	}

	@DisplayName("{1,2,3},1,2,2 = -1 ;;;  Third Car cannot be filled, low capacity")
	@org.junit.jupiter.api.Test
	public void testThreeStationsThirdCarCannotBeFilled() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 1, 2, 3 };

		Assertions.assertEquals(gasStation.solution(source, 1, 2, 2), -1);
	}

	@DisplayName("{1,3,3},1,2,2 = -1 ;;;  Second Car cannot be filled, low capacity")
	@org.junit.jupiter.api.Test
	public void testThreeStationsSecondCarCannotBeFilled() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 1, 3, 3 };

		Assertions.assertEquals(gasStation.solution(source, 1, 2, 2), -1);
	}

	@DisplayName("{3,2,2},2,2,2 = -1 ;;;  First Car cannot be filled, low capacity")
	@org.junit.jupiter.api.Test
	public void testThreeStationsFirstCarCannotBeFilled() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 3, 2, 2 };

		Assertions.assertEquals(gasStation.solution(source, 2, 2, 2), -1);
	}
}
