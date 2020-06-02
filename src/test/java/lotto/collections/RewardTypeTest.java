package lotto.collections;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RewardTypeTest {

	@DisplayName("매칭된 카운트에 따라 타입이 결정된다는 것을 최종적인 리워드 값을 통하여 검증한다.")
	@CsvSource({"5, true, 30000000", "5, false, 1500000", "6, true, 2000000000", "4, false, 50000"})
	@ParameterizedTest
	void 매칭된_카운트에_따라_타입이_결정된다(int matchCount, boolean matchBonus, int rewardValue) {
		RewardType rewardType = RewardType.findTypeByCount(matchCount, matchBonus);
		assertThat(rewardType.getReward().getValue()).isEqualTo(rewardValue);
	}
}
