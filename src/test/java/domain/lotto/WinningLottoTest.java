package domain.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class WinningLottoTest {

	@Test
	void 로또번호_문자열을_번호로_바꾼다() {
		WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6");
		assertThat(winningLotto.getLotto().getNumbers())
			.extracting(LottoNumber::getNumber)
			.containsExactly(1, 2, 3, 4, 5, 6);
	}

	@Test
	void 로또_한장의_등수를_알려준다() {
		WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6");
		Lotto lotto = new Lotto(List.of(
			new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
			new LottoNumber(7), new LottoNumber(8), new LottoNumber(9)));

		assertThat(winningLotto.rank(lotto)).isEqualTo(Rank.FOURTH);
	}

}
