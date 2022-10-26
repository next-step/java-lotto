package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.MoneyException;
import step2.model.Payment;
import step2.model.Rank;

public class PaymentTest {

	@Test
	@DisplayName("1000원당 한장의 로또 티켓이 생긴다")
	void 구입금액테스트() {
		int money = 14000;
		Payment payment = new Payment();
		assertThat(payment.amountOfTicket(money)).isEqualTo(14000 / 1000);
	}

	@Test
	@DisplayName("1000원이하를 지불하면 예외 발생")
	void 금액_부족_테스트() {
		int money = 900;
		Payment payment = new Payment();
		assertThatThrownBy(() -> payment.amountOfTicket(money)).isInstanceOf(
			MoneyException.class);
	}

	@Test
	@DisplayName("티켓은 1000원당 한장이 생긴다.")
	void 잔돈_테스트() {
		int money = 1900;
		Payment payment = new Payment();
		assertThat(payment.amountOfTicket(money)).isEqualTo(1900 / 1000);

	}

	@Test
	@DisplayName("수익률을 계산해준다 - 반올림0")
	void 수익률() {
		int money = 14000;
		Payment payment = new Payment();

		HashMap<Rank, Integer> totalCountMap = new HashMap<>();
		totalCountMap.put(Rank.MISS, 0);
		totalCountMap.put(Rank.FIFTH, 1);
		totalCountMap.put(Rank.FOURTH, 0);
		totalCountMap.put(Rank.THIRD, 0);
		totalCountMap.put(Rank.SECOND, 0);
		totalCountMap.put(Rank.FIRST, 0);

		assertThat(String.format("%.2f", payment.calculateBenefit(money, totalCountMap))).isEqualTo(
			"0.36");
	}

}
