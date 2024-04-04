package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMarketTest {
	@Test
	void 입력한_개수만큼_로또를_발행한다() {
		int numberOfLotto = 1;
		LottoMarket lottoMarket = new LottoMarket(numberOfLotto, () -> List.of(1, 2, 3, 4, 5, 6));
		assertThat(lottoMarket.getLottos()).hasSize(numberOfLotto);
	}
}
