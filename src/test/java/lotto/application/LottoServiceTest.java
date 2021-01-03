package lotto.application;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lotto.domain.RandomLottoNumberGenerator;

class LottoServiceTest {
	private LottoService lottoService = new LottoService(new RandomLottoNumberGenerator());

	@Test
	void buyAutoLottoLotteries_test() {
		int autoCount = 6;
		assertThat(lottoService.buyAutoLottoLotteries(autoCount))
			.hasSize(autoCount);
	}
}