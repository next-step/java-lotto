package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchasedLottosTest {

	@DisplayName("당첨 현황을 표현하는 현황판을 작성한다.")
	@Test
	void test1() {
		List<Lotto> lottos = Arrays.asList(
			new Lotto(0), new Lotto(0),
			new Lotto(3), new Lotto(3),
			new Lotto(4), new Lotto(5)
		);
		PurchasedLottos purchasedLottos = new PurchasedLottos(lottos);
		RankBoard rankBoard = purchasedLottos.makeRankBoard();

		assertThat(rankBoard.winningCount(Rank.MISS)).isEqualTo(2);
		assertThat(rankBoard.winningCount(Rank.FIFTH)).isEqualTo(2);
		assertThat(rankBoard.winningCount(Rank.FOURTH)).isEqualTo(1);
		assertThat(rankBoard.winningCount(Rank.THIRD)).isEqualTo(1);
		assertThat(rankBoard.winningCount(Rank.SECOND)).isEqualTo(0);
		assertThat(rankBoard.winningCount(Rank.FIRST)).isEqualTo(0);
	}
}
