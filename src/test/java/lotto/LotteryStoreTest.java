package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryStoreTest {

	@Test
	void buy() {
		// Arrange
		LotteryStore store = new LotteryStore();

		// Action
		List<LottoTicket> tickets = store.buy(10000);

		// Assertion
		assertThat(tickets.size()).isEqualTo(10);
		tickets.stream().forEach(ticket -> {assertThat(ticket.verify()).isTrue();});
	}
}