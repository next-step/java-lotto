package lotto.collections;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RewardTypeTest {

	private static Stream<Arguments> lottoStatisticsMock() { // argument source method
		Map<Integer, Integer> oneLottoStatistics = new HashMap<>();
		oneLottoStatistics.put(1, 0);
		oneLottoStatistics.put(2, 1);
		oneLottoStatistics.put(3, 1);
		oneLottoStatistics.put(4, 1);
		oneLottoStatistics.put(5, 1);
		oneLottoStatistics.put(6, 0);

		return Stream.of(
			Arguments.of(oneLottoStatistics, 1555000)
		);
	}

	@DisplayName("로또 통계에 따라 당첨 타입과 당첨 금액을 활용하여 최종 수익을 계산한다.")
	@MethodSource("lottoStatisticsMock")
	@ParameterizedTest
	void 로또_통계에_따라_최종_수익을_게산한다(Map<Integer, Integer> lottoStatistics, int profit) {
		assertThat(RewardType.calculateProfit(lottoStatistics)).isEqualTo(profit);
	}
}
