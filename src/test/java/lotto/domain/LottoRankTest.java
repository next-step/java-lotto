package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoRankTest {

	@DisplayName("일치수량에 따라 당첨등수 찾기")
	@CsvSource(value = {"6:false:FIRST", "5:true:SECOND", "5:false:THIRD", "4:false:FOURTH", "3:false:FIFTH", "3:false:FIFTH", "2:false:NOTHING", "1:false:NOTHING", "0:false:NOTHING"}, delimiter = ':')
	@ParameterizedTest
	public void test(int sameQuantity, boolean containBonus, LottoRank lottoRank) {
		assertThat(LottoRank.findBySameQuantity(sameQuantity, containBonus))
			.isEqualTo(lottoRank);
	}
}
