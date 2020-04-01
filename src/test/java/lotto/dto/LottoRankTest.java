package lotto.dto;

import lotto.domain.LottoRank;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

	@ParameterizedTest
	@CsvSource({"5,true,SECOND", "4,false,FOURTH", "5,false,THIRD", "6,false,FIRST"})
	void getFromCorrectNumbers(int correctNumbers, boolean matchBonus, LottoRank expectRank) {
		LottoRank rank = LottoRank.getFromCorrectNumbers(correctNumbers, matchBonus);

		assertThat(rank)
				.isEqualTo(expectRank);

	}
}