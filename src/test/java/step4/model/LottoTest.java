package step4.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {
	Lotto lotto;
	WinnerLotto winnerLotto;

	@BeforeEach
	void beforeEach() {
		lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		winnerLotto = new WinnerLotto("1,2,3,7,8,9", 4);
	}

	@Test
	@DisplayName("당첨번호와 일치되는 번호의 개수를 리턴해야한다.")
	void match() {
		assertEquals(lotto.match(winnerLotto), 3);
	}

	@Test
	@DisplayName("보너스 번호가 해당되는지 그에 맞게 True/False 값을 리턴해야한다.")
	void checkBonus() {
		assertTrue(lotto.checkBonus(winnerLotto));
	}
}