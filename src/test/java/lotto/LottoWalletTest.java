package lotto;

import model.NumberElementCollection;
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

	@Test
	void reportOfResult() {
		// Arrange
		List<LottoTicket> tickets = new ArrayList<>();

		tickets.add(LottoTicket.of(new int[]{1, 2, 10, 	11, 12, 13}));
		tickets.add(LottoTicket.of(new int[]{1, 2, 10, 	11, 12, 13}));
		tickets.add(LottoTicket.of(new int[]{1, 2, 10, 	11, 12, 13}));
		tickets.add(LottoTicket.of(new int[]{1, 2, 10, 	11, 12, 13}));
		tickets.add(LottoTicket.of(new int[]{1, 2, 10, 	11, 12, 13}));
		tickets.add(LottoTicket.of(new int[]{1, 2, 3, 	11, 12, 13}));
		tickets.add(LottoTicket.of(new int[]{1, 2, 3, 	11, 12, 13}));
		tickets.add(LottoTicket.of(new int[]{1, 2, 3, 	11, 12, 13}));
		tickets.add(LottoTicket.of(new int[]{1, 2, 3, 	11, 12, 13}));
		tickets.add(LottoTicket.of(new int[]{1, 2, 3, 	4, 	12, 13}));
		tickets.add(LottoTicket.of(new int[]{1, 2, 3, 	4, 	12, 13}));
		tickets.add(LottoTicket.of(new int[]{1, 2, 3, 	4, 	12, 13}));
		tickets.add(LottoTicket.of(new int[]{1, 2, 3, 	4,	5, 	13}));
		tickets.add(LottoTicket.of(new int[]{1, 2, 3, 	4,	5, 	13}));
		tickets.add(LottoTicket.of(new int[]{1, 2, 3, 	4, 	5, 	6}));

		LottoWallet wallet = new LottoWallet(tickets, 0);

		int[] winNumbers = new int[]{1, 2, 3, 4, 5, 6};
		NumberElementCollection numbers = new NumberElementCollection(6);
		for(int number : winNumbers){
			numbers.add(number);
		}

		// Action
		ResultReport report = wallet.result(numbers);

		// Assertion
		assertThat(report.countOfResult(LottoResult.FAIL)).isEqualTo(5);
		assertThat(report.countOfResult(LottoResult.WIN_4TH)).isEqualTo(4);
		assertThat(report.countOfResult(LottoResult.WIN_3RD)).isEqualTo(3);
		assertThat(report.countOfResult(LottoResult.WIN_2ND)).isEqualTo(2);
		assertThat(report.countOfResult(LottoResult.WIN_1ST)).isEqualTo(1);
	}
}