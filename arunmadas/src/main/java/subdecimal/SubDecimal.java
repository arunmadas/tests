package subdecimal;

public class SubDecimal {

	public int solution(int A, int B) {
		int result = -1;

		String aValue = String.valueOf(A);
		String bValue = String.valueOf(B);

		if (bValue.indexOf(aValue) > -1) {
			return bValue.indexOf(aValue);
		}
		return result;
	}

}
