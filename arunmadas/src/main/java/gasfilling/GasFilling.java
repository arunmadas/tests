package gasfilling;

public class GasFilling {

	public int solution(int[] A, int X, int Y, int Z) {
		int result = -1;

		// if gas stations have no gas
		if (X + Y + Z <= 0)
			return -1;

		// no cars waiting in the line
		if (A.length == 0)
			return -1;

		// if first car has fuel capacity higher than all 3 gas stations, return -1
		if (A[0] > X && A[0] > Y && A[0] > Z)
			return -1;

		// if only one car is waiting to be fueled and any gas station has capacity
		// higher than car fuel capacity
		// return fuel capacity of the car as duration
		if (A.length == 1) {
			return A[0];
		}

		// if two cars are waiting in the queue
		if (A.length == 2) {
			// if first car fuel capacity is lower or equal to station X
			if (A[0] <= X) {
				// if second car fuel capacity can be filled completely at stations Y or Z while
				// first car is fueling at the same instant
				if (A[1] <= Y || A[1] <= Z) {
					// if first car fuel capacity is higher or equal to second car fuel capacity
					if (A[0] >= A[1]) {
						// it takes amount of first car fuel capacity time to fill while second car fuel
						// capacity is smaller or equal to first car
						// since both cars can be filled at same time, first car capacity is considered
						return A[0];
					} else {
						// if second car has larger capacity than first car, and is having capacity
						// available at station Y or Z
						// then second car capacity is longest duration for filling up
						return A[1];
					}
				} else {
					// second car cannot be gas filled at stations Y and Z because car fuel capacity
					// is higher than Y or Z fuel max availability
					// check if first gas station still has gas sufficient for second car after
					// first car is done fueling, then total A[0]+A[1] as total duration
					if (X - A[0] >= A[1]) {
						return A[0] + A[1];
					} else {
						// none of the gas stations have capacity to fill up second car hence return -1
						return -1;
					}
				}
			} else
			// if first car fuel capacity is higher than station X but lower than station Y,
			// first car goes to station Y
			if (A[0] <= Y) {
				// second car can be fueled at any of station X or Z at same time as first car
				// at Y
				if (A[1] <= X || A[1] <= Z) {
					// it takes amount of first car fuel capacity time to fill while second car fuel
					// capacity is smaller or equal to first car
					// since both cars can be filled at same time, first car capacity is considered
					if (A[0] >= A[1]) {
						return A[0];
					} else {
						// if second car has larger capacity than first car, and is having capacity
						// available at station Y or Z
						// then second car capacity is longest duration for filling up
						return A[1];
					}
				} else {
					// second car cannot be gas filled at stations X and Z because car fuel capacity
					// is higher than X or Z fuel max availability
					// check if Y gas station still has gas sufficient for second car after first
					// car is done fueling, then total A[0]+A[1] as total duration
					if (Y - A[0] >= A[1]) {
						return A[0] + A[1];
					} else {
						// none of the gas stations have capacity to fill up second car hence return -1
						return -1;
					}
				}
			} else if (A[0] <= Z) {
				if (A[1] <= X || A[1] <= Y) {

					if (A[0] >= A[1]) {
						return A[0];
					} else {
						return A[1];
					}
				} else {
					if (Z - A[0] > A[1]) {
						return A[0] + A[1];
					} else {
						return -1;
					}
				}
			} else {
				return -1;
			}

		}

		int calculatedTime = 0;

		if (A.length == 3) {

			if (A[0] <= X) {
				if (A[1] <= Y) {
					if (A[2] <= Z) {
						// all 3 gets filled at the same time, which ever car has highest fuel capacity
						// use that
						return Math.max(Math.max(A[0], A[1]), A[2]);
					} else {
						// 3rd car capacity is larger than Z, cannot be fueled at Z

						// check which of first and second can get filled faster
						if (A[0] <= A[1]) {
							calculatedTime += A[0];
							if (X - A[0] >= A[2]) { // third car can go to station X after filling up first car, while
													// second car is still filling up
								if (A[1] - A[0] >= A[2]) { // second car takes longer than after first car filled up
									return A[1];
								} else {
									calculatedTime += A[2]; // third car takes longer here, so add up first car and
															// third car
									return calculatedTime;
								}
							} else { // third car cannot be filled at station X after first car got filled up as
										// third car capacity is much higher
								if (Y - A[1] >= A[2]) {
									calculatedTime += A[1] + A[2];
									return calculatedTime;
								} else {
									return -1;
								}
							}

						} else {

							if (A[2] <= Y - A[1]) {
								calculatedTime = A[1];
								if (A[2] >= X - A[0]) {
									return A[1] + A[2];
								} else {
									return A[0];
								}
							} else {
								if (A[2] <= X - A[0]) {
									return A[0] + A[2];
								} else
									return -1;
							}

						}
					}
				} else if (A[1] <= Z) {
					if (A[2] <= Y) {
						// all 3 gets filled at the same time, which ever car has highest fuel capacity
						// use that
						return Math.max(Math.max(A[0], A[1]), A[2]);
					} else {
						// check which of first and second can get filled faster
						if (A[0] <= A[1]) {
							calculatedTime += A[0];
							if (X - A[0] >= A[2]) { // third car can go to station X after filling up first car, while
													// second car is still filling up
								if (A[1] - A[0] >= A[2]) { // second car takes longer than after first car filled up
									return A[1];
								} else {
									calculatedTime += A[2]; // third car takes longer here, so add up first car and
															// third car
									return calculatedTime;
								}
							} else { // third car cannot be filled at station X after first car got filled up as
										// third car capacity is much higher
								if (Z - A[1] >= A[2]) {
									calculatedTime += A[1] + A[2];
									return calculatedTime;
								} else {
									return -1;
								}
							}

						} else {

							if (A[2] <= Z - A[1]) {
								calculatedTime = A[1];
								if (A[2] >= X - A[0]) {
									return A[1] + A[2];
								} else {
									return A[0];
								}
							} else {
								if (A[2] <= X - A[0]) {
									return A[0] + A[2];
								} else
									return -1;
							}

						}
					}

				} else {
					if (X - A[0] >= A[1]) {
						calculatedTime = A[0];
						if (A[2] <= Y || A[2] <= Z) {
							if (A[2] <= A[1])
								return A[0] + A[1];
							else
								return A[0] + A[1] + A[2];
						} else {
							return A[0] + A[1] + A[2];
						}
					} else {
						return -1;
					}
				}
			} else // second stage
			if (A[0] <= Y) {
				if (A[1] <= X) {
					if (A[2] <= Z) {
						// all 3 gets filled at the same time, which ever car has highest fuel capacity
						// use that
						return Math.max(Math.max(A[0], A[1]), A[2]);
					} else {
						// 3rd car capacity is larger than Z, cannot be fueled at Z

						// check which of first and second can get filled faster
						if (A[0] <= A[1]) {
							calculatedTime += A[0];
							if (Y - A[0] >= A[2]) { // third car can go to station X after filling up first car, while
													// second car is still filling up
								if (A[1] - A[0] >= A[2]) { // second car takes longer than after first car filled up
									return A[1];
								} else {
									calculatedTime += A[2]; // third car takes longer here, so add up first car and
															// third car
									return calculatedTime;
								}
							} else { // third car cannot be filled at station X after first car got filled up as
										// third car capacity is much higher
								if (X - A[1] >= A[2]) {
									calculatedTime += A[1] + A[2];
									return calculatedTime;
								} else {
									return -1;
								}
							}

						} else {

							if (A[2] <= X - A[1]) {
								calculatedTime = A[1];
								if (A[2] >= Y - A[0]) {
									return A[1] + A[2];
								} else {
									return A[0];
								}
							} else {
								if (A[2] <= Y - A[0]) {
									return A[0] + A[2];
								} else
									return -1;
							}

						}
					}
				} else if (A[1] <= Z) {
					if (A[2] <= X) {
						// all 3 gets filled at the same time, which ever car has highest fuel capacity
						// use that
						return Math.max(Math.max(A[0], A[1]), A[2]);
					} else {
						// check which of first and second can get filled faster
						if (A[0] <= A[1]) {
							calculatedTime += A[0];
							if (Y - A[0] >= A[2]) { // third car can go to station X after filling up first car, while
													// second car is still filling up
								if (A[1] - A[0] >= A[2]) { // second car takes longer than after first car filled up
									return A[1];
								} else {
									calculatedTime += A[2]; // third car takes longer here, so add up first car and
															// third car
									return calculatedTime;
								}
							} else { // third car cannot be filled at station X after first car got filled up as
										// third car capacity is much higher
								if (Z - A[1] >= A[2]) {
									calculatedTime += A[1] + A[2];
									return calculatedTime;
								} else {
									return -1;
								}
							}

						} else {
							if (A[2] <= Z - A[1]) {
								calculatedTime = A[1];
								if (A[2] >= Y - A[0]) {
									return A[1] + A[2];
								} else {
									return A[0];
								}
							} else {
								if (A[2] <= Y - A[0]) {
									return A[0] + A[2];
								} else
									return -1;
							}
						}
					}

				} else {
					if (Y - A[0] >= A[1]) {
						calculatedTime = A[0];
						if (A[2] <= X || A[2] <= Z) {
							if (A[2] <= A[1])
								return A[0] + A[1];
							else
								return A[0] + A[1] + A[2];
						} else {
							return A[0] + A[1] + A[2];
						}
					} else {
						return -1;
					}
				}
			} else // third stage
			if (A[0] <= Z) {

				if (A[1] <= X) {
					if (A[2] <= Y) {
						// all 3 gets filled at the same time, which ever car has highest fuel capacity
						// use that
						return Math.max(Math.max(A[0], A[1]), A[2]);
					} else {
						// 3rd car capacity is larger than Z, cannot be fueled at Z

						// check which of first and second can get filled faster
						if (A[0] <= A[1]) {
							calculatedTime += A[0];
							if (Z - A[0] >= A[2]) { // third car can go to station X after filling up first car, while
													// second car is still filling up
								if (A[1] - A[0] >= A[2]) { // second car takes longer than after first car filled up
									return A[1];
								} else {
									calculatedTime += A[2]; // third car takes longer here, so add up first car and
															// third car
									return calculatedTime;
								}
							} else { // third car cannot be filled at station X after first car got filled up as
										// third car capacity is much higher
								if (X - A[1] >= A[2]) {
									calculatedTime += A[1] + A[2];
									return calculatedTime;
								} else {
									return -1;
								}
							}

						} else {

							if (A[2] <= X - A[1]) {
								calculatedTime = A[1];
								if (A[2] >= Z - A[0]) {
									return A[1] + A[2];
								} else {
									return A[0];
								}
							} else {
								if (A[2] <= Z - A[0]) {
									return A[0] + A[2];
								} else
									return -1;
							}

						}
					}
				} else if (A[1] <= Y) {
					if (A[2] <= X) {
						// all 3 gets filled at the same time, which ever car has highest fuel capacity
						// use that
						return Math.max(Math.max(A[0], A[1]), A[2]);
					} else {
						// check which of first and second can get filled faster
						if (A[0] <= A[1]) {
							calculatedTime += A[0];
							if (Z - A[0] >= A[2]) { // third car can go to station X after filling up first car, while
													// second car is still filling up
								if (A[1] - A[0] >= A[2]) { // second car takes longer than after first car filled up
									return A[1];
								} else {
									calculatedTime += A[2]; // third car takes longer here, so add up first car and
															// third car
									return calculatedTime;
								}
							} else { // third car cannot be filled at station X after first car got filled up as
										// third car capacity is much higher
								if (Y - A[1] >= A[2]) {
									calculatedTime += A[1] + A[2];
									return calculatedTime;
								} else {
									return -1;
								}
							}

						} else {
							if (A[2] <= Y - A[1]) {
								calculatedTime = A[1];
								if (A[2] >= Z - A[0]) {
									return A[1] + A[2];
								} else {
									return A[0];
								}
							} else {
								if (A[2] <= Z - A[0]) {
									return A[0] + A[2];
								} else
									return -1;
							}
						}
					}

				} else {
					if (Z - A[0] >= A[1]) {
						calculatedTime = A[0];
						if (A[2] <= X || A[2] <= Y) {
							if (A[2] <= A[1])
								return A[0] + A[1];
							else
								return A[0] + A[1] + A[2];
						} else {
							return A[0] + A[1] + A[2];
						}
					} else {
						return -1;
					}
				}

			}

		}

		/*
		 * for(int i = 0; i < A.length-2; i++) { //all cars go in paralle to all
		 * stations if(A[i] <= X && A[i+1] <= Y && A[i+2]<= Z) { //check which car has
		 * highest capacity return Math.max(Math.max(A[i], A[i+1]), A[i+2]); } else
		 * if(A[i] <= X) {
		 * 
		 * }
		 * 
		 * }
		 */

		return result;
	}

}
