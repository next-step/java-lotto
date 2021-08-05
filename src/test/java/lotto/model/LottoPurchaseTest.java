package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseTest {

	@Test
	@DisplayName("입력된 로또게임 장수 만큼 로또게임이 생성된다.")
	public void createMoneyByLottoGame() {
		assertThat(LottoPurchase.buyLotteries(4000).size()).isEqualTo(4);

		assertThat(LottoPurchase.buyLotteries(6000).size()).isEqualTo(6);
	}

}