package step2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticTest {
	private static LottoStatistic statistic;
	private static Map<Integer, Integer> result;

	@BeforeAll
	static void setLottoStatistic() {
		statistic = new LottoStatistic(Arrays.asList(1, 2, 3, 4, 5, 6));
		result = statistic.calcLottoResult(Arrays.asList(
				new Integer[]{1, 2, 3, 6, 10, 40},
				new Integer[]{4, 5, 13, 15, 39, 40}));
	}

	@DisplayName(value = "로또 당첨 갯수 계산 기능 테스트")
	@Test
	void calcWinningLottoCount() {
		assertThat(result).hasEntrySatisfying(3, number -> assertThat(number).isEqualTo(0));
		assertThat(result).hasEntrySatisfying(4, number -> assertThat(number).isEqualTo(1));
	}

	@DisplayName(value = "총 수익 계산 기능 테스트")
	@Test
	void calcWinningsSum() {
		assertThat(statistic.calcWinningsSum()).isEqualTo(50000);
	}
}
