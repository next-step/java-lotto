package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPaymentTest {

	@Test
	@DisplayName("돈과 수동 로또 수를 입력받으면 수동 로또수와 자동 로또수가 반환된다.")
	public void createLottoCount() {
		LottoPayment lottoPayment = new LottoPayment(3, new Money(7000));

		int manualLottoCount = lottoPayment.getManualLottoCount();
		int autoLottoCount = lottoPayment.getAutoLottoCount();

		assertThat(manualLottoCount).isEqualTo(3);
		assertThat(autoLottoCount).isEqualTo(4);
	}

	@Test
	@DisplayName("수동 로또 수가 음수이면 예외가 발생된다.")
	public void checkPositiveCount() {
		assertThrows(IllegalArgumentException.class, () ->
			new LottoPayment(-1, new Money(7000))
		);
	}

	@Test
	@DisplayName("수동 로또 수가 금액을 초과하면 예외가 발생된다.")
	public void checkOverMoney() {
		assertThrows(IllegalArgumentException.class, () ->
			new LottoPayment(8, new Money(7000))
		);
	}

}