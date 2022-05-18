package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoRankTest {

	@DisplayName("일치수량에 따라 당첨등수 찾기")
	@CsvSource(value = {"6:0:FIRST", "5:1:SECOND", "5:0:THIRD", "4:0:FOURTH", "3:0:FIFTH", "3:1:FIFTH", "2:0:NOTHING", "1:0:NOTHING", "0:0:NOTHING"}, delimiter = ':')
	@ParameterizedTest
	public void test(int sameQuantity, int bonusQuantity, LottoRank lottoRank) {
		assertThat(LottoRank.findBySameQuantity(sameQuantity, bonusQuantity))
			.isEqualTo(lottoRank);
	}
}
