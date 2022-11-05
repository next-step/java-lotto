package step3.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoCheckerTest {
	@Test
	void getEarningRate() {
		HashMap<Integer, Integer> testMap = new HashMap<>();
		testMap.put(1, 1);
		testMap.put(4, 1);
		testMap.put(5, 1);
		Money money = new Money(2100000000);
		double earningRate = LottoChecker.getEarningRate(testMap, money);
		assertEquals(Math.floor(earningRate * 100) / 100.0, 0.95);
	}

	@Test
	void match() {
		WinnerLotto winnerLotto = new WinnerLotto("1, 2, 3, 4, 5, 6", 7);
		Lotto lotto = new Lotto(List.of(1, 2, 4, 5, 7, 3));
		LottoChecker lottoChecker = new LottoChecker(winnerLotto);
		assertEquals(lottoChecker.match(lotto), 2);
	}
}