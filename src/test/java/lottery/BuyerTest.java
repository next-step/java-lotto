package lottery;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;

import org.junit.jupiter.api.Test;

class BuyerTest {

	Buyer sut;

	@Test
	void createBuyerTest() {

		sut = Buyer.of(Money.won(10000L));

		assertThat(sut.money()).isEqualTo(Money.won(10000L));
		assertThat(sut.lotteryTickets()).isEqualTo(Collections.emptyList());
	}
}
