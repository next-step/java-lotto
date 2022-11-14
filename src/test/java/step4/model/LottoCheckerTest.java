package step4.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoCheckerTest {

	@Test
	void match() {
		WinnerLotto winnerLotto = new WinnerLotto("1, 2, 3, 4, 5, 6", 7);
		Lotto lotto = new Lotto(List.of(1, 2, 4, 5, 7, 3));
		LottoChecker lottoChecker = new LottoChecker(winnerLotto);
		assertEquals(lottoChecker.match(lotto), 2);
	}
}