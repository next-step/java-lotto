package lottery;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BuyerTest {

	private Buyer sut;

	@Test
	void createBuyerTest() {
		assertThatThrownBy(() -> Buyer.of(null))
			.isInstanceOf(IllegalArgumentException.class).hasMessageContaining("유효하지 않은 값입니다.");

		sut = Buyer.of(Money.won(10000L));

		assertThat(sut.money()).isEqualTo(Money.won(10000L));
		assertThat(sut.tickets()).isEqualTo(Tickets.EMPTY_TICKETS);
	}
}
