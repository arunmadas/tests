package gasstationfilling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import gasfilling.GasStationFillingGeneric;

@DisplayName("Gas Station Filling Tests - Only One Car in the Queue with 3 Stations available to fill Gas ")
public class GasStationFillingForOneCarTest {

	@DisplayName("{},2,1,3 = -1 ;;; No Cars in the Queue")
	@org.junit.jupiter.api.Test
	public void testThreeStationsNoCarsInQueue() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] {};

		Assertions.assertEquals(gasStation.solution(source, 2, 1, 3), -1);
	}

	@DisplayName("{5},2,1,3 = -1 ;;; Three Gas Stations Cannot fill up larger capacity Car 5 liter")
	@org.junit.jupiter.api.Test
	public void testThreeStationsOneCar() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 5 };

		Assertions.assertEquals(gasStation.solution(source, 2, 1, 3), -1);
	}

	@DisplayName("{2},2,1,3 = 2 ;;; Car with 2 liter fuel capacity should get filled at alphabatical X gas station 2 seconds")
	@org.junit.jupiter.api.Test
	public void testThreeStationsOneCarFilledAtX() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 2 };

		Assertions.assertEquals(gasStation.solution(source, 2, 1, 3), 2);
	}

	@DisplayName("{3},1,2,3 = 3 ;;; Car with 3 liter fuel capacity should first try to get filled at stations 1 and 2 but cannot fill because of size but gets filled at station 3")
	@org.junit.jupiter.api.Test
	public void testThreeStationsOneCarFilledAtZ() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 3 };

		Assertions.assertEquals(gasStation.solution(source, 1, 2, 3), 3);
	}

	@DisplayName("{6},6,6,6 = 6 ;;;  All Gas stations have same capacity, car should get filled at first station leaving stations 2 and 3 open")
	@org.junit.jupiter.api.Test
	public void testThreeStationsSameCapacityFilledAtX() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 6 };

		Assertions.assertEquals(gasStation.solution(source, 6, 6, 6), 6);
	}

	@DisplayName("{2},0,0,0 = -1 ;;;  All Gas stations are empty, car cannot be filled at any gas station")
	@org.junit.jupiter.api.Test
	public void testThreeStationsEmptyCannotFill() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 2 };

		Assertions.assertEquals(gasStation.solution(source, 0, 0, 0), -1);
	}

}
