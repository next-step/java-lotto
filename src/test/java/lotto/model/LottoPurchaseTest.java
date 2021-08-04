package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseTest {

	@Test
	@DisplayName("입력된 로또게임 장수 만큼 로또게임이 생성된다.")
	public void createMoneyByLottoGame() {
		LottoPurchase lottoPurchase = new LottoPurchase(4000);

		assertThat(lottoPurchase.resultLottoGame().size()).isEqualTo(4);

		LottoPurchase lottoPurchase2 = new LottoPurchase(6000);

		assertThat(lottoPurchase2.resultLottoGame().size()).isEqualTo(6);
	}

}