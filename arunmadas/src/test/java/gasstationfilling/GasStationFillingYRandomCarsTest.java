package gasstationfilling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import gasfilling.GasStationFillingGeneric;

@DisplayName("Gas Station Filling Tests - Random Cars in the Queue with 3 Stations available to fill Gas ")
public class GasStationFillingYRandomCarsTest {

	@DisplayName("{3,5,6,7,3,2,2,2},14,22,3 = 14 ;;; Random cars, larger capacities")
	@org.junit.jupiter.api.Test
	public void testThreeStationsThreeCarsSameCapacitySameTimeFilling() {
		GasStationFillingGeneric gasStation = new GasStationFillingGeneric();
		int[] source = new int[] { 3, 5, 6, 7, 3, 2, 2, 2 };
		Assertions.assertEquals(gasStation.solution(source, 14, 22, 3), 14);
	}
	
}
