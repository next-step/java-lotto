package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.factory.WinningBallsFactory;

public class RankingTest {

	@Test
	public void getRankingTest() {
		Lottos lottos = Lottos.of(Arrays.asList(new Lotto(LottoNumbers.of(Arrays.asList(1, 5, 11, 24, 35, 44))),
												new Lotto(LottoNumbers.of(Arrays.asList(1, 5, 11, 34, 35, 41))),
												new Lotto(LottoNumbers.of(Arrays.asList(4, 6, 10, 24, 35, 41))),
												new Lotto(LottoNumbers.of(Arrays.asList(1, 5, 11, 34, 36, 42))),
												new Lotto(LottoNumbers.of(Arrays.asList(1, 5, 11, 34, 36, 41))),
												new Lotto(LottoNumbers.of(Arrays.asList(3, 7, 11, 29, 30, 41))),
												new Lotto(LottoNumbers.of(Arrays.asList(3, 5, 11, 29, 30, 41)))));

		WinningBalls winningBalls = WinningBallsFactory.create("1,5,11,34,36,42");
		List<Ranking> rankings = lottos.getRankings(winningBalls);
		assertThat(rankings).containsExactly(Ranking.FOURTH,
											 Ranking.THIRD,
											 Ranking.FAILURE,
											 Ranking.FIRST,
											 Ranking.SECOND,
											 Ranking.FAILURE,
											 Ranking.FAILURE);
	}
}
