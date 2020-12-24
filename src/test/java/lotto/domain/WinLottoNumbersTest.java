package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WinLottoNumbersTest {
	@Test
	void create_test() {
		assertThat(new WinLottoNumbers("1,2,3,4,5,6").getWinNumbers())
			.hasSize(6)
			.containsExactly(
				new LottoNumber(1),
				new LottoNumber(2),
				new LottoNumber(3),
				new LottoNumber(4),
				new LottoNumber(5),
				new LottoNumber(6)
			);
	}
}
