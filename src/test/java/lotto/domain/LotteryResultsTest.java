package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.type.WinningType;

class LotteryResultsTest {
	private static final int NUMBER_OF_MISMATCH = 13;
	private static final int NUMBER_OF_FOURTH = 1;
	private LotteryResults lotteryResults;

	@BeforeEach
	void init() {
		List<LotteryResult> lotteryResultList = new ArrayList<>();
		for (int i = 0; i < NUMBER_OF_MISMATCH; i++) {
			LotteryResult lotteryResult = new LotteryResult(null, WinningType.MISMATCH);
			lotteryResultList.add(lotteryResult);
		}
		lotteryResultList.add(new LotteryResult(null, WinningType.FOURTH));

		lotteryResults = new LotteryResults(lotteryResultList);
	}

	@DisplayName(value = "총 수익률 계산 테스트")
	@Test
	void calculateTotalYield() {
		float expect = 0.36f;

		float totalYield = lotteryResults.getTotalYield();
		float result = Math.round(totalYield * 100) / 100.0f;

		assertThat(result).isEqualTo(expect);
	}

	@DisplayName(value = "당첨 통계 테스트")
	@Test
	void drawResult() {
		Map<WinningType, Integer> drawResultMap = lotteryResults.getDrawResult();

		int resultMismatch = drawResultMap.get(WinningType.MISMATCH);
		int resultFourth = drawResultMap.get(WinningType.FOURTH);

		assertThat(resultMismatch).isEqualTo(NUMBER_OF_MISMATCH);
		assertThat(resultFourth).isEqualTo(NUMBER_OF_FOURTH);
	}
}