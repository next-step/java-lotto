package domain.lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class WinningLottoTest {

	@Test
	void 로또번호_문자열을_번호로_바꾼다() {
		WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6");
		assertThat(winningLotto.getLotto().getNumbers())
			.extracting(LottoNumber::getNumber)
			.containsExactly(1, 2, 3, 4, 5, 6);
	}
}
