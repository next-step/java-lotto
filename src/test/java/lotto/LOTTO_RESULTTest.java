package lotto;

import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LOTTO_RESULTTest {

	@ParameterizedTest
	@DisplayName("일치한 로또 숫자에 따라 등수를 나타내는 로직을 테스트")
	@CsvSource(value = {
			"1,2,3,4,5,6|1,7,8,9,10,11|NOTHING",
			"1,2,3,4,5,6|1,2,8,9,10,11|NOTHING",
			"1,2,3,4,5,6|1,2,3,9,10,11|MATCHED_THREE",
			"1,2,3,4,5,6|1,2,3,4,10,11|MATCHED_FOUR",
			"1,2,3,4,5,6|1,2,3,4,5,11|MATCHED_FIVE",
			"1,2,3,4,5,6|1,2,3,4,5,6|MATCHED_SIX",
	}, delimiter = '|')
	void findMatchedResult(String stringTryLottoNumbers, String stringWinningNumbers, LOTTO_RESULT expectedLottoResult) {
		// given
		LottoNumbers tryLottoNumbers = toLottoNumbers(stringTryLottoNumbers);
		LottoNumbers winningNumbers = toLottoNumbers(stringWinningNumbers);

		// when
		LOTTO_RESULT lottoResult = LOTTO_RESULT.findMatchedResult(tryLottoNumbers, winningNumbers);

		// then
		assertThat(lottoResult).isEqualTo(expectedLottoResult);
	}

	private LottoNumbers toLottoNumbers(String numbers) {
		List<LottoNumber> lottoNumberList = TestUtils.toLottoNumberList(numbers);
		return new LottoNumbers(lottoNumberList);
	}

}