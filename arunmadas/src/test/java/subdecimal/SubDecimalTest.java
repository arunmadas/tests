package subdecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Sub Decimal Test - Find Lowest Occurance of Decimal Integer Value in Another Large Number")
public class SubDecimalTest  {

	@DisplayName("{53, 125345} = 2 ;;; Found Index in the middle")
	@org.junit.jupiter.api.Test
	public void testFoundIndexInMiddle() {
		SubDecimal dec = new SubDecimal();
		Assertions.assertEquals(dec.solution(53,125345), 2);
	}
	
	@DisplayName("{53, 536745} = 0 ;;; Found Index in the beginning")
	@org.junit.jupiter.api.Test
	public void testFoundIndexInBeginning() {
		SubDecimal dec = new SubDecimal();
		Assertions.assertEquals(dec.solution(53,536745), 0);
	}
	
	@DisplayName("{5, 236745} = 5 ;;; Found Index in the End")
	@org.junit.jupiter.api.Test
	public void testFoundIndexInTheEnd() {
		SubDecimal dec = new SubDecimal();
		Assertions.assertEquals(dec.solution(5,236745), 5);
	}
	
	@DisplayName("{78, 195398678} = 7 ;;; Found Index Twice Pick Lowest")
	@org.junit.jupiter.api.Test
	public void testFoundIndexInTheEndTwoDigit() {
		SubDecimal dec = new SubDecimal();
		Assertions.assertEquals(dec.solution(78,195398678), 7);
	}
	
	@DisplayName("{78, 195378678} = 4 ;;; Found Index Twice Pick Lowest")
	@org.junit.jupiter.api.Test
	public void testFoundIndexTwice() {
		SubDecimal dec = new SubDecimal();
		Assertions.assertEquals(dec.solution(78,195378678), 4);
	}
	
	@DisplayName("{57, 153786} = -1 ;;; Found No Index")
	@org.junit.jupiter.api.Test
	public void testFoundNoIndex() {
		SubDecimal dec = new SubDecimal();
		Assertions.assertEquals(dec.solution(57,153786), -1);
	}
	

	@DisplayName("{0, 0} = 0 ;;; Found Same Number")
	@org.junit.jupiter.api.Test
	public void testFoundSameNumber() {
		SubDecimal dec = new SubDecimal();
		Assertions.assertEquals(dec.solution(0,0), 0);
	}
	
	@DisplayName("{999999999, 999999999} = 0 ;;; Found Largest Same Number")
	@org.junit.jupiter.api.Test
	public void testFoundLargestSameNumber() {
		SubDecimal dec = new SubDecimal();
		Assertions.assertEquals(dec.solution(999999999,999999999), 0);
	}
	
	@DisplayName("{8978, 123489780} = 4 ;;; Found Four Digit Number in Middle")
	@org.junit.jupiter.api.Test
	public void testFoundFourDigitInMiddle() {
		SubDecimal dec = new SubDecimal();
		Assertions.assertEquals(dec.solution(8978,123489780), 4);
	}
	

	@DisplayName("{-1, -1123489780} = 0 ;;; Found Negative Digit Number in Beginning")
	@org.junit.jupiter.api.Test
	public void testFoundNegativeMiddle() {
		SubDecimal dec = new SubDecimal();
		Assertions.assertEquals(dec.solution(-1,-1123489780), 0);
	}
	
	@DisplayName("{-1, -34214780} = -1 ;;; Cannot Find Negative Digit Number")
	@org.junit.jupiter.api.Test
	public void testCannotFoundNegative() {
		SubDecimal dec = new SubDecimal();
		Assertions.assertEquals(dec.solution(-1,-34234780), -1);
	}
}