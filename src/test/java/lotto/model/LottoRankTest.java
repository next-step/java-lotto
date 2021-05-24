package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankTest {

	@Test
	@DisplayName("자신의 상금에 횟수를 곱한 결과를 반환해야 한다.")
	public void multiplyPrizeTest() {
		Money money = LottoRank.FOURTH.multiplyPrize(4);

		assertThat(money).isEqualTo(Money.ofWons(20_0000));
	}

	@ParameterizedTest
	@DisplayName("일치 숫자와 보너스 숫자에 따라서 LottoRank 가 결정된다.")
	@CsvSource(value = {"6:false:FIRST", "6:true:FIRST", "5:true:SECOND", "5:false:THIRD",
		"4:false:FOURTH", "4:true:FOURTH", "3:false:FIFTH", "3:true:FIFTH"},
		delimiter = ':')
	public void firstRankTest(int countOfMatch, boolean matchBonus, LottoRank expectedRank) {
		LottoRank lottoRank = LottoRank.of(countOfMatch, matchBonus);

		assertThat(lottoRank).isEqualTo(expectedRank);
	}

}