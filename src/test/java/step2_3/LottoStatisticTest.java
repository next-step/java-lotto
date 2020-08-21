package step2_3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2_3.domain.Lotto;
import step2_3.domain.LottoStatistic;
import step2_3.domain.LottoWinning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticTest {
	private static LottoStatistic statistic;
	private static List<Lotto> purchaseLottos;

	@BeforeAll
	static void setLottoStatistic() {
		statistic = new LottoStatistic(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 10);

		purchaseLottos = new ArrayList<>();
		purchaseLottos.add(new Lotto(Arrays.asList(1, 2, 3, 6, 10, 40)));
		purchaseLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)));
		purchaseLottos.add(new Lotto(Arrays.asList(4, 5, 13, 15, 39, 40)));
		purchaseLottos.add(new Lotto(Arrays.asList(10, 14, 23, 25, 34, 44)));
	}

	@DisplayName(value = "로또 당첨 갯수 계산 기능 테스트")
	@Test
	void calcWinningLottoCount() {
		Map<LottoWinning, Integer> result = statistic.calcLottoResult(purchaseLottos);
		assertThat(result).hasEntrySatisfying(LottoWinning.valueOf(4, false), number -> assertThat(number).isEqualTo(1));
		assertThat(result).hasEntrySatisfying(LottoWinning.valueOf(5, true), number -> assertThat(number).isEqualTo(1));
	}

	@DisplayName(value = "수익률 계산 기능 테스트")
	@Test
	void calcYield() {
		statistic.calcLottoResult(purchaseLottos);
		assertThat(statistic.calcYield(10000)).isEqualTo(3005);
	}
}
