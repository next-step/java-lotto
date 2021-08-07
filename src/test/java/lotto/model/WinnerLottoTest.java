package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerLottoTest {

	@Test
	@DisplayName("지난 로또번호를 입력하면 로또번호가 반환된다.")
	public void createWinnerLotto() {
		WinnerLotto winnerLotto = new WinnerLotto("1,2,3,4,5,6");

		List<LottoNumber> result = winnerLotto.getWinnerLotto();

		assertThat(result).containsExactly(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
			new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
	}
}