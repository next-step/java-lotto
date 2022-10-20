package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.LackOfMoneyException;
import step2.model.Payment;

public class PaymentTest {

	@Test
	@DisplayName("1000원당 한장의 로또 티켓이 생긴다")
	void 구입금액테스트() {
		int money = 14000;
		Payment payment = new Payment();
		assertThat(payment.lottoAmount(money)).isEqualTo(14000 / 1000);
	}

	@Test
	@DisplayName("1000원이하를 지불하면 예외 발생")
	void 금액_부족_테스트() {
		int money = 900;
		Payment payment = new Payment();
		assertThatThrownBy(() -> payment.lottoAmount(money)).isInstanceOf(
			LackOfMoneyException.class);
	}

	@Test
	@DisplayName("수익률을 계산해준다 - 반올림0")
	void 수익률() {
		int money = 14000;
		Payment payment = new Payment();

		HashMap<Integer, Integer> totalCountMap = new HashMap<>();
		totalCountMap.put(3, 1);
		totalCountMap.put(4, 0);
		totalCountMap.put(5, 0);
		totalCountMap.put(6, 0);

		assertThat(payment.rateBenefit(money, totalCountMap)).isEqualTo("0.36");
	}
}
