package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoWalletTest {

	@Test
	void verifyToString() {
		// Arrange
		List<LottoTicket> tickets = new ArrayList<>();

		tickets.add(LottoTicket.of(new int[]{1, 2, 3, 4, 5, 6}));
		tickets.add(LottoTicket.of(new int[]{7, 8, 9, 10, 11, 12}));

		LottoWallet wallet = new LottoWallet(tickets, 0);

		// Action
		String print = wallet.toString();

		// Assertion
		assertThat(print).isEqualTo("[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]");

	}
}