package lotto;

import lotto.domain.LotteryStore;
import lotto.domain.LottoWallet;
import lotto.domain.TicketMachine;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryStoreTest {

	@Test
	void buy() {
		// Arrange
		LotteryStore store = new LotteryStore(new TicketMachine());

		// Action
		LottoWallet wallet = store.buy(10000);

		// Assertion
		assertThat(wallet.ticketCount()).isEqualTo(10);
		assertThat(wallet.hasBalance()).isFalse();
	}
}