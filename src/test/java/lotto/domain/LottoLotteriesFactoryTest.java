package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoLotteriesFactoryTest {
	@Test
	@DisplayName("갯수만큼 로또를 자동으로 생성한다.")
	void createAutoLottoLotteries_test() {
		int count = 4;
		LottoLotteries lottoLotteries = LottoLotteriesFactory.createAutoLottoLotteries(count,
			new RandomLottoNumberGenerator());

		assertThat(lottoLotteries.getCount())
			.isEqualTo(count);
	}
}