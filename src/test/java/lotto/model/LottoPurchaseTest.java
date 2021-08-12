package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseTest {

	@Test
	@DisplayName("입력된 로또게임 장수 만큼 로또게임이 생성된다.")
	public void createMoneyByLottoGame() {
		Payment payment = new Payment(3, new Money(4000));
		String[] manualLottos = new String[3];
		manualLottos[0] = "1,2,3,4,5,6";
		manualLottos[1] = "1,3,5,7,9,11";
		manualLottos[2] = "2,4,6,8,10,12";
		assertThat(LottoPurchase.buyLottos(payment, manualLottos).getLottos().size()).isEqualTo(4);
	}

	@Test
	@DisplayName("수동 압력된 로또는 로또를 알수 있다.")
	public void createManualLottos() {
		Payment payment = new Payment(2, new Money(2000));
		String[] manualLottos = new String[2];
		manualLottos[0] = "1,2,3,4,5,6";
		manualLottos[1] = "1,3,5,7,9,11";
		assertThat(LottoPurchase.buyLottos(payment, manualLottos).getLottos()).containsExactly(
			new Lotto(manualLottos[0]), new Lotto(manualLottos[1]));
	}

}