package lotto;

import lotto.option.LottoMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class LottoStoreTest {

	@ParameterizedTest
	@CsvSource(value = {"14000,14", "1000,1"})
	@DisplayName("정상적인 금액으로 로또를 판매했을때 그 금액만큼 로또번호를 주는지 테스트")
	void sell_정상금액(int money, int lottoCount) {
		// given
		LottoStore lottoStore = new LottoStore();
		LottoMoney lottoMoney = new LottoMoney(money);

		// when & then
		assertThat(lottoStore.sell(lottoMoney).size()).isEqualTo(lottoCount);
	}
}
