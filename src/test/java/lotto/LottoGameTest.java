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

		assertThat(lottoGame.buyLotto(new Money(money)).size()).isEqualTo(14);

		assertThatThrownBy(() -> {
			lottoGame.buyLotto(new Money(0));
		}).isExactlyInstanceOf(IllegalArgumentException.class);
	}
}
