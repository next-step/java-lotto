package lotto.result;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

	@ParameterizedTest
	@CsvSource(value = {
			"-1,false,NOTHING", "-5,false,NOTHING",
			"1,false,NOTHING", "1,true,NOTHING",
			"2,false,NOTHING", "2,true,NOTHING",
			"3,false,MATCHED_THREE", "3,true,MATCHED_THREE",
			"4,false,MATCHED_FOUR", "4,true,MATCHED_FOUR",
			"5,false,MATCHED_FIVE", "5,true,MATCHED_FIVE_WITH_BONUS",
			"6,false,MATCHED_SIX"
	})
	void findMatchedResult(int numberMatchedCount, boolean isBonusBallMatched, LottoResult expected) {
		assertThat(LottoResult.findMatchedResult(numberMatchedCount, isBonusBallMatched)).isEqualTo(expected);
	}
}
