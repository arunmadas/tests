package coin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Coin Flip Test - Find Maximum Adjacent Coin Count")
public class CoinSequenceTest {

	@DisplayName("{1} = Flipped {0} = Count 0 ;;; Only one coin")
	@org.junit.jupiter.api.Test
	public void testThreeStationsOnlyOneCoin() {
		CoinSequence coin = new CoinSequence();
		int[] source = new int[] { 1 };

		Assertions.assertEquals(coin.solution(source), 0);
	}

	@DisplayName("{0} = Flipped {1} = Count 0 ;;; Only one coin")
	@org.junit.jupiter.api.Test
	public void testThreeStationsOnlyOneCoinZero() {
		CoinSequence coin = new CoinSequence();
		int[] source = new int[] { 0 };

		Assertions.assertEquals(coin.solution(source), 0);
	}

	@DisplayName("{0,0} = Flipped {1,0} = Count 0 ;;; Two coins same direction before flipping")
	@org.junit.jupiter.api.Test
	public void testThreeStationsTwoCoinsSameFacingZero() {
		CoinSequence coin = new CoinSequence();
		int[] source = new int[] { 0, 0 };

		Assertions.assertEquals(coin.solution(source), 0);
	}

	@DisplayName("{1,1} = Flipped {0,1} = Count 0 ;;; Two coins same direction before flipping Ones")
	@org.junit.jupiter.api.Test
	public void testThreeStationsTwoCoinsSameFacingOnes() {
		CoinSequence coin = new CoinSequence();
		int[] source = new int[] { 1, 1 };

		Assertions.assertEquals(coin.solution(source), 0);
	}

	@DisplayName("{0,1} = Flipped {0,0} = Count 1 ;;; Two coins 0,1 flip to Zeros or Ones")
	@org.junit.jupiter.api.Test
	public void testThreeStationsTwoCoinsFlipToZeros() {
		CoinSequence coin = new CoinSequence();
		int[] source = new int[] { 0, 1 };

		Assertions.assertEquals(coin.solution(source), 1);
	}

	@DisplayName("{1,1,1} = Flipped {0,1,1} = Count 1 ;;; 3 coins flip one coin")
	@org.junit.jupiter.api.Test
	public void testAllOnesFlipOne() {
		CoinSequence coin = new CoinSequence();
		int[] source = new int[] { 1, 1, 1 };

		Assertions.assertEquals(coin.solution(source), 1);
	}
	
	@DisplayName("{0,1,1} = Flipped {1,1,1} = Count 2 ;;; 3 coins flip to all ones")
	@org.junit.jupiter.api.Test
	public void testFlipToThreeOnes() {
		CoinSequence coin = new CoinSequence();
		int[] source = new int[] { 0, 1, 1 };

		Assertions.assertEquals(coin.solution(source), 2);
	}
	
	@DisplayName("{0,0,1,1,0,1} = Flipped {0,0,1,1,1,1} = Count 3")
	@org.junit.jupiter.api.Test
	public void testFlipToFlipSeq4Mixed() {
		CoinSequence coin = new CoinSequence();
		int[] source = new int[] { 0,0, 1, 1, 0, 1 };

		Assertions.assertEquals(coin.solution(source), 4);
	}
	
	@DisplayName("{0,1,0,1,0,1} = Flipped {0,1,1,1,0,1} = Count 2")
	@org.junit.jupiter.api.Test
	public void testFlipToFlipSeq2Mixed() {
		CoinSequence coin = new CoinSequence();
		int[] source = new int[] { 0,1, 0, 1, 0, 1 };

		Assertions.assertEquals(coin.solution(source), 2);
	}

	@DisplayName("{0,0,0,0} = Flipped {0,0,0,1} = Count 2")
	@org.junit.jupiter.api.Test
	public void testFlipToFourZeros() {
		CoinSequence coin = new CoinSequence();
		int[] source = new int[] { 0,0, 0, 0 };

		Assertions.assertEquals(coin.solution(source), 2);
	}
	
	@DisplayName("{1,1,1,1} = Flipped {1,1,1,0} = Count 2")
	@org.junit.jupiter.api.Test
	public void testFlipToFourOnes() {
		CoinSequence coin = new CoinSequence();
		int[] source = new int[] { 1,1, 1, 1 };

		Assertions.assertEquals(coin.solution(source), 2);
	}
	
	@DisplayName("{1,0,0,0,0,0} = Flipped {0,0,0,0,0,0} = Count 5")
	@org.junit.jupiter.api.Test
	public void testFlipToFiveZeros() {
		CoinSequence coin = new CoinSequence();
		int[] source = new int[] { 1,0, 0, 0,0,0 };

		Assertions.assertEquals(coin.solution(source), 5);
	}
	
	@DisplayName("{0,1,1,1,1,1} = Flipped {1,1,1,1,1,1} = Count 5")
	@org.junit.jupiter.api.Test
	public void testFlipToFiveOnes() {
		CoinSequence coin = new CoinSequence();
		int[] source = new int[] { 0,1, 1, 1,1,1 };

		Assertions.assertEquals(coin.solution(source), 5);
	}
	
	@DisplayName("{0,0,1,0,0,0} = Flipped {0,0,0,0,0,0} = Count 5")
	@org.junit.jupiter.api.Test
	public void testFlipToFiveOnesMiddleOne() {
		CoinSequence coin = new CoinSequence();
		int[] source = new int[] { 0,0, 1, 0,0,0 };

		Assertions.assertEquals(coin.solution(source), 5);
	}
}
