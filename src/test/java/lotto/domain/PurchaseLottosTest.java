package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("구매로또 테스트")
public class PurchaseLottosTest {

	private WinningLotto winningLotto;

	@BeforeEach
	void setUp() {
		Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
		int bonusNumber = 7;
		winningLotto = new WinningLotto(lotto, bonusNumber);
	}

	@Test
	@DisplayName("수동과 자동을 포함한 구매한 로또의 결과 테스트")
	void findResult() {

		Lottos manaulLottos = new Lottos(
				new Lotto(1, 2, 3, 4, 5, 6),
				new Lotto(1, 2, 3, 4, 5, 6),
				new Lotto(1, 2, 3, 4, 5, 7),
				new Lotto(11, 12, 13, 14, 15, 16)
		);

		Lottos autoLottos = new Lottos(
				new Lotto(1, 2, 3, 4, 5, 6),
				new Lotto(1, 2, 3, 4, 5, 45),
				new Lotto(1, 2, 3, 4, 44, 45),
				new Lotto(1, 2, 3, 43, 44, 45)
		);

		PurchaseLottos purchaseLottos = new PurchaseLottos(manaulLottos, autoLottos);
		LottoResults lottoResults = purchaseLottos.findResult(winningLotto);

		Assertions.assertThat(lottoResults.findRankCount(Rank.FIRST)).isEqualTo(3);
		Assertions.assertThat(lottoResults.findRankCount(Rank.SECOND)).isEqualTo(1);
		Assertions.assertThat(lottoResults.findRankCount(Rank.THIRD)).isEqualTo(1);
		Assertions.assertThat(lottoResults.findRankCount(Rank.FOURTH)).isEqualTo(1);
		Assertions.assertThat(lottoResults.findRankCount(Rank.FIFTH)).isEqualTo(1);
		Assertions.assertThat(lottoResults.findRankCount(Rank.NONE)).isEqualTo(1);
	}

}
