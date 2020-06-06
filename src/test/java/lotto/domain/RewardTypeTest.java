package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.domain.RewardType;

public class RewardTypeTest {

	@DisplayName("매칭된 카운트에 따라 타입이 결정된다는 것을 최종적인 리워드 값을 통하여 검증한다.")
	@CsvSource({"5, true, 30000000", "5, false, 1500000", "6, true, 2000000000", "4, false, 50000"})
	@ParameterizedTest
	void 매칭된_카운트에_따라_타입이_결정된다(int matchCount, boolean matchBonus, int rewardValue) {
		RewardType rewardType = RewardType.findTypeByCount(matchCount, matchBonus);
		assertThat(rewardType.getReward().getValue()).isEqualTo(rewardValue);
	}

	private static Stream<Arguments> lottoStatisticsMock() { // argument source method
		List<RewardType> oneLottoStatistics = new ArrayList<>();
		oneLottoStatistics.add(RewardType.NOTHING);
		oneLottoStatistics.add(RewardType.THIRD);
		oneLottoStatistics.add(RewardType.FOURTH);
		oneLottoStatistics.add(RewardType.FIFTH);

		return Stream.of(
			Arguments.of(oneLottoStatistics, 1555000)
		);
	}

	@DisplayName("WinningService에서 수행하던 통계 로직을 RewardType으로 성공적으로 이관했는 지 검증한다.")
	@MethodSource("lottoStatisticsMock")
	@ParameterizedTest
	void 로또_통계에_따라_최종_수익을_계산한다(List<RewardType> lottoStatistics, int profit) {
		assertThat(RewardType.calculateProfit(lottoStatistics)).isEqualTo(profit);
	}
}
