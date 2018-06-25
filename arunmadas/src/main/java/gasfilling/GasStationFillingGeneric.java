package gasfilling;

public class GasStationFillingGeneric {

	public int solution(int[] A, int X, int Y, int Z) {
		
		int[] stationAvailable = new int[] {0,0,0}; // 0 = available, 1 = busy
		int[] carCurrentlyFilling = new int[] {0,0,0}; // 0 = no car filling, x = amt of car fuel capacity
		
		if(A.length == 0) { return -1; }
		
		int calculatedTime = 0;
		for(int i = 0; i < A.length; i++) {
			
			if(A[i] > X && A[i] > Y && A[i] > Z) { return -1; } //gas not available
			
				//when every 4th, 7th, 10th, 13th etc. cars arrive,
				//if all 3 stations are held up and next car arrives, pick lowest fuel capacity car currently filling and consume the amount of gas from all other cars fuel capacity
				if(stationAvailable[0]==1 && stationAvailable[1]==1 && stationAvailable[2]==1) {
					
					//find lowestcarfuel
					int lowestCarFuelCurrentlyFilling = carCurrentlyFilling[0];
					for(int k = 0 ; k < 3; k++) {
						if(lowestCarFuelCurrentlyFilling >= carCurrentlyFilling[k]) {
							lowestCarFuelCurrentlyFilling = carCurrentlyFilling[k];
						}
					}
					
					//consume lowest fuel from all stations
					X-=lowestCarFuelCurrentlyFilling; 
					Y-=lowestCarFuelCurrentlyFilling; 
					Z-=lowestCarFuelCurrentlyFilling;
					carCurrentlyFilling[0]-=lowestCarFuelCurrentlyFilling;
					carCurrentlyFilling[1]-=lowestCarFuelCurrentlyFilling;
					carCurrentlyFilling[2]-=lowestCarFuelCurrentlyFilling;
					calculatedTime+=lowestCarFuelCurrentlyFilling; //jump the timeline to lowestCarFuelCapacity
					
					//free up stations with zero capacity at one go
					freeGasStation(stationAvailable, carCurrentlyFilling);					
				}

			if(A[i] > X && A[i] > Y && A[i] > Z) { return -1; } //gas not available (after lowest consumptions)
				
			boolean isCarBeingFilled = false;
			isCarBeingFilled = assignCarToOpenStationWithEnoughCapacity(A, X, Y, Z, stationAvailable,
					carCurrentlyFilling, i, isCarBeingFilled);
			
			//car cannot be filled at any open gas station,  
			//	or car might have to wait until one of the occupied gas station leaves to check release qty
			if(!isCarBeingFilled) {
								
				//if incoming car capacity is higher than that of all of the occupied gas stations, return -1				
				if(stationAvailable[0]==0 && stationAvailable[1]==0 && stationAvailable[2]==0) { return -1; }				
				
				//find the lowest fuel car among the occupied stations and consume up the gas for the second car
				// remember here there is at-least one station that is free but is not having enough capacity
				int lowestSecondFuel = stationAvailable[0] == 1 ? carCurrentlyFilling[0] : (stationAvailable[1] == 1 ? carCurrentlyFilling[1] : (stationAvailable[2] == 1 ? carCurrentlyFilling[2] : 9999999));
				for(int m = 0 ; m < 3; m++) {
					if(stationAvailable[m]==1 && lowestSecondFuel >= carCurrentlyFilling[m]) {
							lowestSecondFuel = carCurrentlyFilling[m];
					}
				}
				
				//consume the lowest fuel among the occupied stations and free up station
				if(stationAvailable[0]==1) {
					X-=lowestSecondFuel; 
					carCurrentlyFilling[0]-=lowestSecondFuel;
				}
				
				if(stationAvailable[1]==1) {
					Y-=lowestSecondFuel;
					carCurrentlyFilling[1]-=lowestSecondFuel;										
				}
				
				if(stationAvailable[2]==1) {
					Z-=lowestSecondFuel;
					carCurrentlyFilling[2]-=lowestSecondFuel;										
				}
				
				freeGasStation(stationAvailable, carCurrentlyFilling);
				
				calculatedTime+=lowestSecondFuel; //jump the timeline to lowestSecondFuel
				
				//find the lowest fuel car among the occupied stations, here only one station should be occupied
				//consume up the lowest fuel car, only occupied station and try to assign and free up station.
				if(A[i] > X && A[i] > Y && A[i] > Z) { return -1; } //gas not available (after lowest consumptions)
				
				boolean isCarCanBeFilled = false;
				isCarCanBeFilled = assignCarToOpenStationWithEnoughCapacity(A, X, Y, Z, stationAvailable,
						carCurrentlyFilling, i, isCarCanBeFilled);
				
				if(!isCarCanBeFilled) {
					//only one station is occupied here,
					int lowestThirdFuel = stationAvailable[0] == 1 ? carCurrentlyFilling[0] : (stationAvailable[1] == 1 ? carCurrentlyFilling[1] : (stationAvailable[2] == 1 ? carCurrentlyFilling[2] : 9999999));

					//if incoming car capacity is higher than that of all of the occupied gas stations, return -1				
					if(stationAvailable[0]==0 && stationAvailable[1]==0 && stationAvailable[2]==0) { return -1; }	
					
					//consume the lowest fuel among the occupied stations and free up station
					if(stationAvailable[0]==1) {
						X-=lowestSecondFuel; 
						carCurrentlyFilling[0]-=lowestThirdFuel;
					}
					
					if(stationAvailable[1]==1) {
						Y-=lowestSecondFuel;
						carCurrentlyFilling[1]-=lowestThirdFuel;										
					}
					
					if(stationAvailable[2]==1) {
						Z-=lowestSecondFuel;
						carCurrentlyFilling[2]-=lowestThirdFuel;										
					}
					
					freeGasStation(stationAvailable, carCurrentlyFilling);
					
					calculatedTime+=lowestThirdFuel; //jump the timeline to lowestThirdFuel

					if(A[i] > X && A[i] > Y && A[i] > Z) { return -1; } //gas not available (after lowest consumptions)
					
					boolean isCarCanBeFilledLastTime = false;
					//check the stations assignment to car in the order - Station X
					isCarCanBeFilledLastTime = assignCarToOpenStationWithEnoughCapacity(A, X, Y, Z, stationAvailable,
							carCurrentlyFilling, i, isCarCanBeFilledLastTime);
					
					if(!isCarCanBeFilledLastTime) {
						return -1;
					}
				}
			}
			
		}
		
		int maxCarCapacity = Math.max(Math.max(carCurrentlyFilling[0], carCurrentlyFilling[1]),carCurrentlyFilling[2]);
		calculatedTime+=maxCarCapacity;
		
		return calculatedTime;
	}

	private boolean assignCarToOpenStationWithEnoughCapacity(int[] A, int X, int Y, int Z, int[] stationAvailable,
			int[] carCurrentlyFilling, int i, boolean isCarCanBeFilledLastTime) {
		if(stationAvailable[0]==0 && A[i] <= X) {
			stationAvailable[0] = 1;
			carCurrentlyFilling[0] = A[i];
			isCarCanBeFilledLastTime=true;
		}			
		else if(stationAvailable[1] == 0 && A[i] <= Y) { //station - Y
			stationAvailable[1]=1;
			carCurrentlyFilling[1] = A[i];
			isCarCanBeFilledLastTime = true;
		} 
		else if(stationAvailable[2] == 0 && A[i] <= Z) { //station - Z
			stationAvailable[2]=1;
			carCurrentlyFilling[2] = A[i];
			isCarCanBeFilledLastTime = true;
		}
		return isCarCanBeFilledLastTime;
	}

	private void freeGasStation(int[] stationAvailable, int[] carCurrentlyFilling) {
		for(int l = 0 ; l < 3; l++) {
			if(carCurrentlyFilling[l] == 0) {
				stationAvailable[l] = 0;
			}
		}
	}
	
}
