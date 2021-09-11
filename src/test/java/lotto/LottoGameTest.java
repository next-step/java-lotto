package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGameTest {

	@Test
	@DisplayName("로또 구매 갯수 확인")
	void buy() {
		LottoGame lottoGame = new LottoGame();
		int money = 14000;

		assertThat(lottoGame.buyLotto(money).size()).isEqualTo(money / LottoRule.LOTTO_PRICE);

		assertThatThrownBy(() -> {
			lottoGame.buyLotto(0);
		}).isExactlyInstanceOf(IllegalArgumentException.class);
	}
}
