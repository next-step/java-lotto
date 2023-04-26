package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoMachineTest {

	@DisplayName("구매한 만큼의 로또를 생성한다.")
	@Test
	void test1() {
		assertThat(new LottoMachine(14000).purchasedCount()).isEqualTo(14);
	}

	@DisplayName("구매한 만큼의 로또를 생성한다. - 예외 케이스")
	@ValueSource(longs = {800, 1400})
	@ParameterizedTest
	void test2(long purchaseAmount) {
		assertThatIllegalArgumentException().isThrownBy(() -> new LottoMachine(purchaseAmount));
	}

	@DisplayName("총 수익을 계산한다.")
	@Test
	void test3() {
		List<PrizeSituation> prizeSituations = Arrays.asList(
			new PrizeSituation(PrizeType.SIX, 2),
			new PrizeSituation(PrizeType.THREE, 1)
		);
		LottoMachine lottoMachine = new LottoMachine();
		assertThat(lottoMachine.totalProfit(prizeSituations)).isEqualTo(4000005000L);
	}

	@DisplayName("총 수익률을 계산한다.")
	@Test
	void test4() {
		LottoMachine lottoMachine = new LottoMachine();
		assertThat(lottoMachine.totalProfitRate(5000, 14000)).isEqualTo(0.35);
	}

	@DisplayName("손익 여부를 계산한다. - 이득인 케이스")
	@Test
	void test5() {
		LottoMachine lottoMachine = new LottoMachine();
		assertThat(lottoMachine.isBenefit(1.01)).isTrue();
	}

	@DisplayName("손익 여부를 계산한다. - 손해인 케이스")
	@Test
	void test6() {
		LottoMachine lottoMachine = new LottoMachine();
		assertThat(lottoMachine.isBenefit(0.99)).isFalse();
	}

	@DisplayName("당첨 현황을 표현하는 현황판을 작성한다.")
	@Test
	void test7() {
		List<Lotto> lottos = Arrays.asList(
			new Lotto(0), new Lotto(0),
			new Lotto(3), new Lotto(3)
		);
		LottoMachine lottoMachine = new LottoMachine();
		Map<Score, Integer> scoreBoard = lottoMachine.makeScoreBoard(lottos);

		assertThat(scoreBoard.get(new Score(0))).isNull();
		assertThat(scoreBoard.get(new Score(2))).isNull();
		assertThat(scoreBoard.get(new Score(3))).isEqualTo(2);
		assertThat(scoreBoard.get(new Score(6))).isEqualTo(0);
	}

	@DisplayName("상금 현황 목록을 작성한다.")
	@Test
	void test8() {
		List<Lotto> lottos = Arrays.asList(
			new Lotto(0), new Lotto(0),
			new Lotto(3), new Lotto(3),
			new Lotto(6)
		);
		LottoMachine lottoMachine = new LottoMachine(lottos);
		List<PrizeSituation> prizeSituations = lottoMachine.makePrizeSituations();

		assertThat(prizeSituations).containsExactlyInAnyOrder(
			new PrizeSituation(PrizeType.THREE, 2), new PrizeSituation(PrizeType.FOUR, 0),
			new PrizeSituation(PrizeType.FIVE, 0), new PrizeSituation(PrizeType.SIX, 1));
	}

	@DisplayName("상금 현황 목록을 점수순으로 오름차순 정렬한다.")
	@Test
	void test9() {
		List<PrizeSituation> prizeSituations = Arrays.asList(
			new PrizeSituation(PrizeType.FOUR, 0), new PrizeSituation(PrizeType.SIX, 1),
			new PrizeSituation(PrizeType.FIVE, 0), new PrizeSituation(PrizeType.THREE, 2)
		);
		LottoMachine lottoMachine = new LottoMachine();
		List<PrizeSituation> sortedPrizeSituations = lottoMachine.sortInOrderScore(prizeSituations);
		assertThat(sortedPrizeSituations).containsExactly(
			new PrizeSituation(PrizeType.THREE, 2), new PrizeSituation(PrizeType.FOUR, 0),
			new PrizeSituation(PrizeType.FIVE, 0), new PrizeSituation(PrizeType.SIX, 1)
		);
	}
}
