package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaymentTest {

	@Test
	@DisplayName("1000원당 한장의 로또 티켓이 생긴다")
	void 구입금액테스트(){
		int money = 14000;
		Payment payment = new Payment();
		Assertions.assertThat(payment.lottoAmount(money)).isEqualTo(14000/1000);
	}

	@Test
	@DisplayName("1000원이하를 지불하면 예외 발생")
	void 금액_부족_테스트(){
		int money = 900;
		Payment payment = new Payment();
		Assertions.assertThatThrownBy(() -> payment.lottoAmount(money)).isInstanceOf(new LackOfMoneyException.class);
	}
}
