package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또게임 테스트")
public class LottoGameTest {

	@Test
	@DisplayName("구매금액이 로또를 구입하기 위한 최소금액이 안될경우 예외발생 테스트")
	void createLottoGame() {
		Assertions.assertThatThrownBy(() -> new LottoGame(999))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("구매금액으로 몇개의 로또를 구입할 수 있는지 테스트")
	void findNumberOfAvailablePurchases() {
		int money = 14000;
		LottoGame lottoGame = new LottoGame(money);
		int lottoCount = lottoGame.findNumberOfAvailablePurchases();
		assertThat(lottoCount).isEqualTo(14);
	}

	@Test
	@DisplayName("구매금액으로 로또를 구매하는 테스트")
	void purchaseLottos() {
		LottoGame lottoGame = new LottoGame(14000, new TestRandomNumbersGenerator(new Integer[]{1, 2, 3, 4, 5, 6}));
		assertThat(lottoGame.hasSize()).isEqualTo(14);
	}

	@Test
	@DisplayName("구매한 로또의 당첨 결과를 구하는 테스트")
	void findWinningResult() {
		LottoGame lottoGame = new LottoGame(1000, new TestRandomNumbersGenerator(new Integer[]{1, 2, 3, 4, 5, 6}));
		LottoResult lottoResult = lottoGame.findWinningResult(new LottoNumbers(1, 2, 3, 43, 44, 45));
		assertThat(lottoResult.getStatMap().get(Rank.FOURTH)).isEqualTo(1);
		assertThat(lottoResult.findPercentageOfRevenue()).isEqualTo(5.0f);
	}

}
