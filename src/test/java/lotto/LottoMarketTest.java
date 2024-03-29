package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMarketTest {
	@Test
	void 천원당_한장의_로또를_발행한다() {
		LottoMarket lottoMarket = new LottoMarket(1000);
		assertThat(lottoMarket.getLottos()).hasSize(1);
	}
}
