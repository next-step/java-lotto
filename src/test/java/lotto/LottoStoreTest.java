package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
class LottoStoreTest {

	@ParameterizedTest
	@CsvSource(value = {"14000,14", "1000,1"})
	@DisplayName("정상적인 금액으로 로또를 판매했을때 그 금액만큼 로또번호를 주는지 테스트")
	void sell_정상금액(int money, int lottoCount) {
		// given
		LottoStore lottoStore = new LottoStore();

		// when & then
		assertThat(lottoStore.sell(money)).hasSize(lottoCount);
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, -1000, 0})
	@DisplayName("구매 금액이 양수가 아닐경우 예외처리 테스트")
	void sell_음수(int money) {
		// given
		LottoStore lottoStore = new LottoStore();

		// when & then
		assertThatThrownBy(() -> lottoStore.sell(money))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("money is not positive");
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 5, 999})
	@DisplayName("구매 금액이 잔돈이 남을경우 예외처리 테스트")
	void sell_잔돈(int money) {
		// given
		LottoStore lottoStore = new LottoStore();

		// when & then
		assertThatThrownBy(() -> lottoStore.sell(money))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("change exist");
	}
}
