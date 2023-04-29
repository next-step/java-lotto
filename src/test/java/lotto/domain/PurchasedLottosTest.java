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
			new Lotto(3), new Lotto(3)
		);
		PurchasedLottos purchasedLottos = new PurchasedLottos(lottos);
		ScoreBoard scoreBoard = purchasedLottos.makeScoreBoard();

		assertThat(scoreBoard.winCount(new Score(0))).isNull();
		assertThat(scoreBoard.winCount(new Score(2))).isNull();
		assertThat(scoreBoard.winCount(new Score(3))).isEqualTo(2);
		assertThat(scoreBoard.winCount(new Score(6))).isEqualTo(0);
	}
}
