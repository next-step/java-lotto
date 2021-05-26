package lottery;

import static lottery.Money.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BuyerTest {

	private Buyer sut;

	@Test
	void createBuyerTest() {
		assertThatThrownBy(() -> Buyer.of(null))
			.isInstanceOf(IllegalArgumentException.class).hasMessageContaining(NOT_VALID_MONEY_EXCEPTION_MESSAGE);

		assertThatThrownBy(() -> Buyer.of(Money.won(-1L)))
			.isInstanceOf(IllegalArgumentException.class).hasMessageContaining(NOT_VALID_MONEY_EXCEPTION_MESSAGE);

		sut = Buyer.of(Money.won(10000L));

		assertThat(sut.money()).isEqualTo(Money.won(10000L));
		assertThat(sut.tickets()).isEqualTo(Tickets.EMPTY_TICKETS);
	}
}
