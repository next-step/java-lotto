package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoRankTest {

	@DisplayName("일치수량에 따라 당첨등수 찾기")
	@CsvSource(value = {"6:FIRST", "5:SECOND", "4:THIRD", "3:FOURTH", "2:NOTHING", "1:NOTHING", "0:NOTHING"}, delimiter = ':')
	@ParameterizedTest
	public void test(int sameQuantity, LottoRank lottoRank) {
		assertThat(LottoRank.findBySameQuantity(sameQuantity))
			.isEqualTo(lottoRank);
	}
}
