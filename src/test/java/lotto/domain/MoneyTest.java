package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.exception.InsufficientMoneyException;

class MoneyTest {

	@DisplayName("금액을 포장하는 Money 객체를 생성한다.")
	@Test
	void create() {
		assertThat(new Money(1000)).isEqualTo(new Money(1000));
	}

	@DisplayName("금액이 1,000원 미만일 경우 로또를 살 수 없으므로 예외가 발생한다.")
	@Test
	void insufficientMoney() {
		assertThatThrownBy(() -> new Money(900))
			.isInstanceOf(InsufficientMoneyException.class);
	}

	@DisplayName("현재 금액으로 구매할 수 있는 로또 티켓의 매수를 계산한다.")
	@CsvSource(value = {"10000,10", "5500,5"})
	@ParameterizedTest
	void calculateLottoTicketsCount(int amount, int expectedLottoTicketsCount) {
		Money money = new Money(amount);
		assertThat(money.availableLottoTicketsCount()).isEqualTo(expectedLottoTicketsCount);
	}

	@DisplayName("로또 티켓을 구매할 경우 로또 티켓 매수만큼의 금액을 차감한다.")
	@Test
	void subtractPriceOfLottoTickets() {
		Money money = new Money(9000);
		assertThat(money.balanceAfterBuyingNumberOfLottoTickets(5)).isEqualTo(new Money(4000));
	}

}
