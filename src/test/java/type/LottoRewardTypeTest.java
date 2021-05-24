package type;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRewardTypeTest {

	@ParameterizedTest(name = "일치하는 숫자별 Lotto.LottoRewardType 테스트. collect[{0}], reward[{1}]")
	@CsvSource(value = {
		"0, NONE", "1, NONE", "3, PLACE_4TH", "4, PLACE_3TH", "5, PLACE_2TH", "6, PLACE_1TH", "7, NONE"
	})
	void rewardTest(final int collect, final LottoRewardType reward) {
		assertThat(LottoRewardType.of(collect))
			.isEqualTo(reward);
	}
}
