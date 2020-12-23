package lotto;

import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;
import lotto.number.WinningNumbers;
import lotto.result.LottoResult;
import lotto.result.LottoStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTicketTest {

	@ParameterizedTest
	@CsvSource(value = {"1,0", "0,1", "5,3"})
	@DisplayName("올바른 생성자 호출")
	void constructor(int autoSize, int manualSize) {
		assertDoesNotThrow(() -> new LottoTicket(createAnyNumbers(autoSize), createAnyNumbers(manualSize)));
	}

	@Test
	@DisplayName("예외가 발생하는 생성자 호출")
	void constructor_exception() {
		assertThatThrownBy(() -> new LottoTicket(Collections.emptyList(), Collections.emptyList()))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("must be at least one");
	}

	@ParameterizedTest
	@CsvSource(value = {"1,0", "0,1", "5,3"})
	@DisplayName("객체 내부의 LottoNumbers 갯수가 올바른지 확인")
	void size(int autoSize, int manualSize) {
		final LottoTicket lottoTicket = new LottoTicket(createAnyNumbers(autoSize), createAnyNumbers(manualSize));
		assertThat(lottoTicket.autoNumbersSize() + lottoTicket.manualNumbersSize())
				.isEqualTo(autoSize + manualSize);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,0", "0,1", "5,3"})
	@DisplayName("객체 내부의 LottoNumbers 갯수와 toStringList 크기가 동일한지 확인")
	void toStringNumbers(int autoSize, int manualSize) {
		final LottoTicket lottoTicket = new LottoTicket(createAnyNumbers(autoSize), createAnyNumbers(manualSize));
		assertThat(lottoTicket.toStringNumbers()).hasSize(autoSize + manualSize);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,0", "0,1", "5,3"})
	@DisplayName("LottoStatistics 를 만들때 객체 내부의 LottoNumbers 의 사이즈와 통계의 갯수가 같은지검증")
	void compareNumbers(int autoSize, int manualSize) {
		// given
		final LottoTicket lottoTicket = new LottoTicket(createAnyNumbers(autoSize), createAnyNumbers(manualSize));

		// when
		LottoStatistics lottoStatistics = lottoTicket.compareNumbers(
				createResultFixedWinningNumber(LottoResult.NOTHING), TestUtils.anyMoney());

		// then
		assertThat(lottoStatistics.getCount(LottoResult.NOTHING)).isEqualTo(autoSize + manualSize);
		assertThat(lottoStatistics.getCount(LottoResult.MATCHED_THREE)).isZero();
		assertThat(lottoStatistics.getCount(LottoResult.MATCHED_FOUR)).isZero();
		assertThat(lottoStatistics.getCount(LottoResult.MATCHED_FIVE)).isZero();
		assertThat(lottoStatistics.getCount(LottoResult.MATCHED_FIVE_WITH_BONUS)).isZero();
		assertThat(lottoStatistics.getCount(LottoResult.MATCHED_SIX)).isZero();
	}

	private List<LottoNumbers> createAnyNumbers(int size) {
		List<LottoNumbers> lottoNumbersList = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			lottoNumbersList.add(TestUtils.createLottoNumbers(1, 2, 3, 4, 5, 6));
		}
		return lottoNumbersList;
	}

	private WinningNumbers createResultFixedWinningNumber(LottoResult lottoResult) {
		LottoNumbers lottoNumbers = TestUtils.createLottoNumbers(1, 2, 3, 4, 5, 6);
		LottoNumber bonusNumber = new LottoNumber(9);
		return new WinningNumbers(lottoNumbers, bonusNumber) {
			@Override
			public LottoResult findMatchedResult(LottoNumbers lottoNumbers) {
				return lottoResult;
			}
		};
	}
}
