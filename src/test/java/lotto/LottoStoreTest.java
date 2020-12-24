package lotto;

import lotto.number.LottoNumbers;
import lotto.option.LottoBuyPlan;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class LottoStoreTest {

	@ParameterizedTest
	@CsvSource(value = {"14000,3,11", "1000,1,0", "1000,0,1"})
	@DisplayName("정상적인 금액으로 로또를 판매했을때 그 금액만큼 로또번호를 주는지 테스트")
	void sell_정상금액(long money, long manualLottoCount, long expectedAutoLottoCount) {

		// given
		LottoStore lottoStore = new LottoStore();
		LottoBuyPlan lottoBuyPlan = new LottoBuyPlan(money, createAnyLottoNumbers(manualLottoCount));

		// when & then
		LottoTicket lottoTicket = lottoStore.sell(lottoBuyPlan);
		assertThat(lottoTicket.manualNumbersSize()).isEqualTo(manualLottoCount);
		assertThat(lottoTicket.autoNumbersSize()).isEqualTo(expectedAutoLottoCount);
	}

	private List<LottoNumbers> createAnyLottoNumbers(long count) {
		List<LottoNumbers> lottoNumbersList = new ArrayList<>();
		for (long i = 0; i < count; i++) {
			lottoNumbersList.add(TestUtils.createLottoNumbers(1, 2, 3, 4, 5, 6));
		}
		return lottoNumbersList;
	}
}
