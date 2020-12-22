package lotto.option;

import lotto.TestUtils;
import lotto.number.LottoNumbers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoBuyPlanTest {

	@ParameterizedTest
	@CsvSource(value = {"1000, 1", "1000, 0", "5000,3"})
	void constructor_noException(long money, long manualLottoCount) {
		// given
		List<LottoNumbers> lottoNumbers = this.createAnyLottoNumbers(manualLottoCount);

		// when & then
		assertDoesNotThrow(() -> new LottoBuyPlan(money, lottoNumbers));
	}

	@ParameterizedTest
	@CsvSource(value = {"1000, 2", "5000, 10"})
	void constructor_exception(long money, long manualLottoCount) {
		// given
		List<LottoNumbers> lottoNumbers = this.createAnyLottoNumbers(manualLottoCount);

		// when & then
		assertThatThrownBy(() -> new LottoBuyPlan(money, lottoNumbers))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("cannot be over");
	}

	private List<LottoNumbers> createAnyLottoNumbers(long count) {
		List<LottoNumbers> lottoNumbersList = new ArrayList<>();
		for (long i = 0; i < count; i++) {
			lottoNumbersList.add(TestUtils.createLottoNumbers(1,2,3,4,5,6));
		}
		return lottoNumbersList;
	}
}
