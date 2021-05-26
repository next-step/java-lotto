package type;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRewardTypeTest {

	@ParameterizedTest(name = "일치하는 숫자별 Lotto.LottoRewardType 테스트. collect[{0}], reward[{1}]")
	@CsvSource(value = {
		"0,false,NONE",
		"1,false,NONE",
		"3,false,FIFTH",
		"4,false,FOURTH",
		"5,false,THIRD",
		"5,true,SECOND",
		"6,false,FIRST"
	})
	void rewardTest(final int collect, final boolean matchBonus, final LottoRewardType reward) {
		assertThat(LottoRewardType.of(collect, matchBonus))
			.isEqualTo(reward);
	}
}
