package lotto;

import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;
import lotto.number.WinningNumbers;
import lotto.result.LottoResult;
import lotto.result.LottoStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

	@ParameterizedTest
	@ValueSource(ints = {0, 5, 10})
	@DisplayName("객체 내부의 LottoNumbers 갯수가 올바른지 확인")
	void size(int size) {
		final LottoTicket lottoTicket = new LottoTicket(createAnyNumbers(size));
		assertThat(lottoTicket.size()).isEqualTo(size);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 5, 10})
	@DisplayName("객체 내부의 LottoNumbers 갯수와 toStringList 크기가 동일한지 확인")
	void toStringNumbers(int size) {
		final LottoTicket lottoTicket = new LottoTicket(createAnyNumbers(size));
		assertThat(lottoTicket.toStringNumbers()).hasSize(size);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 5, 10})
	@DisplayName("LottoStatistics 를 만들때 객체 내부의 LottoNumbers 의 사이즈와 통계의 갯수가 같은지검증")
	void compareNumbers(int size) {
		// given
		LottoTicket lottoTicket = new LottoTicket(createAnyNumbers(size));

		// when
		LottoStatistics lottoStatistics = lottoTicket.compareNumbers(
				createResultFixedWinningNumber(LottoResult.NOTHING));

		// then
		assertThat(lottoStatistics.getCount(LottoResult.NOTHING)).isEqualTo(size);
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