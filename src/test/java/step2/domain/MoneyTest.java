package step2.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step2.exception.MoneyOverLimitException;
import step2.exception.NotEnoughMoneyException;

class MoneyTest {

	@Test
	@DisplayName("주어진 money를 넘었을때 throw 하는지 테스트")
	void checkMaxMoneyTest() {
		Money money = new Money(4000);
		assertThatThrownBy(() -> {
			money.checkMaxMoney(3000);
		}).isInstanceOf(MoneyOverLimitException.class);
	}

	@Test
	@DisplayName("getPurchasableCount()가 구매 가능한 개수를 잘 반환하는지 테스트")
	void getPurchasableCountTest() {
		Money money1 = new Money(3000);
		assertThat(money1.getPurchasableCount(1000)).isEqualTo(3);

		Money money2 = new Money(5500);
		assertThat(money2.getPurchasableCount(2000)).isEqualTo(2);
	}

	@Test
	@DisplayName("getPurchasableCount()가 구매 불가 할 때 잘 throw 하는지 테스트")
	void getPurchasableCountThrowTest() {
		Money money = new Money(1000);
		assertThatThrownBy(() -> {
			money.getPurchasableCount(2000);
		}).isInstanceOf(NotEnoughMoneyException.class);
	}

	@Test
	@DisplayName("수익률 체크하는 테스트")
	void getProfitByGainedMoneyTest() {
		Money money = new Money(1000);
		assertThat(money.getProfitByGainedMoney(3000)).isEqualTo(200);
	}
}