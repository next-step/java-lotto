package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryStoreTest {

	@Test
	void buy() {

		LotteryStore store = new LotteryStore();
		List<LottoTicket> tickets = store.buy(10000);

		assertThat(tickets.size()).isEqualTo(10);
	}
}