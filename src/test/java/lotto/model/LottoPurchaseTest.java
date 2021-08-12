package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseTest {

	@Test
	@DisplayName("입력된 로또게임 장수 만큼 로또게임이 생성된다.")
	public void createMoneyByLottoGame() {
		LottoPayment lottoPayment = new LottoPayment(3, new Money(4000));
		String[] manualLottos = new String[3];
		manualLottos[0] = "1,2,3,4,5,6";
		manualLottos[1] = "1,3,5,7,9,11";
		manualLottos[2] = "2,4,6,8,10,12";
		assertThat(LottoPurchase.buyLottos(lottoPayment, manualLottos).getLottos().size()).isEqualTo(4);
	}

}