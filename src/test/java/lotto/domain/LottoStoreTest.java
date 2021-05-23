package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStoreTest {

	private final LottoStore lottoStore = new LottoStore();

	@DisplayName("로또 구매 테스트")
	@Test
	void buy() {
		// given
		Money money = new Money("10000");

		// when
		LottoGame lottoGame = lottoStore.buy(money);

		// then
		assertThat(lottoGame).isNotNull();
	}

	@DisplayName("유효성 체크 테스트")
	@Test
	void invalid() {
		// then
		assertThatThrownBy(() -> lottoStore.buy(new Money("10"))).isInstanceOf(IllegalArgumentException.class);
	}

}
