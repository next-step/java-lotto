package step2.service;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static step2.service.LottoGame.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step2.domain.Money;
import step2.exception.MoneyOverLimitException;
import step2.exception.NotEnoughMoneyException;

class LottoGameTest {
	@Test
	@DisplayName("구입 금액이 1000원보다 낮을경우 익셉션을 던지는 테스트")
	public void minMoneyCheckTest() {
		assertThatThrownBy(() -> {
			Money money = new Money(LOTTO_PRICE - 100);
			playLotto(money);
		}).isInstanceOf(NotEnoughMoneyException.class);
	}

	@Test
	@DisplayName("최대 10만원을 초과할 경우 익셉션을 던지는 테스트")
	public void maxMoneyCheckTest() {
		assertThatThrownBy(() -> {
			Money money = new Money(MAX_LOTTO_PURCHASE_AMOUNT + 1000);
			playLotto(money);
		}).isInstanceOf(MoneyOverLimitException.class);

	}
}