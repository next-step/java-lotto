package lotto;

import common.NumberElement;
import common.NumberElementCollection;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWallet;
import lotto.domain.ResultReport;
import lotto.model.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWalletTest {

	@DisplayName("지갑내용 출력 확인")
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

	@DisplayName("당첨결과 통계 데이터 확인")
	@Test
	void reportOfResult() {
		// Arrange
		List<LottoTicket> tickets = new ArrayList<>();

		tickets.add(LottoTicket.of(new int[]{1, 2, 10, 11, 12, 13}));
		tickets.add(LottoTicket.of(new int[]{1, 2, 10, 11, 12, 13}));
		tickets.add(LottoTicket.of(new int[]{1, 2, 10, 11, 12, 13}));
		tickets.add(LottoTicket.of(new int[]{1, 2, 10, 11, 12, 13}));
		tickets.add(LottoTicket.of(new int[]{1, 2, 10, 11, 12, 13}));

		tickets.add(LottoTicket.of(new int[]{1, 2, 3,  11, 12, 13}));
		tickets.add(LottoTicket.of(new int[]{1, 2, 3,  11, 12, 13}));
		tickets.add(LottoTicket.of(new int[]{1, 2, 3,  11, 12, 13}));
		tickets.add(LottoTicket.of(new int[]{1, 2, 3,  11, 12, 13}));

		tickets.add(LottoTicket.of(new int[]{1, 2, 3,   4, 12, 13}));
		tickets.add(LottoTicket.of(new int[]{1, 2, 3, 	4, 12, 13}));
		tickets.add(LottoTicket.of(new int[]{1, 2, 3, 	4, 12, 13}));

		tickets.add(LottoTicket.of(new int[]{1, 2, 3, 	4,	5, 13}));
		tickets.add(LottoTicket.of(new int[]{1, 2, 3, 	4,	5, 13}));

		tickets.add(LottoTicket.of(new int[]{1, 2, 3, 	4, 	5, 45}));

		tickets.add(LottoTicket.of(new int[]{1, 2, 3, 	4, 	5, 	6}));

		LottoWallet wallet = new LottoWallet(tickets, 0);

		int[] winNumbers = new int[]{1, 2, 3, 4, 5, 6};
		NumberElementCollection numbers = new NumberElementCollection(6);
		for(int number : winNumbers){
			numbers.add(number);
		}

		NumberElement bonusNumber = new NumberElement(45);

		// Action
		ResultReport report = wallet.result(numbers, bonusNumber);

		// Assertion
		assertThat(report.countOfResult(LottoResult.FAIL)).isEqualTo(5);
		assertThat(report.countOfResult(LottoResult.WIN_5TH)).isEqualTo(4);
		assertThat(report.countOfResult(LottoResult.WIN_4TH)).isEqualTo(3);
		assertThat(report.countOfResult(LottoResult.WIN_3RD)).isEqualTo(2);
		assertThat(report.countOfResult(LottoResult.WIN_2ND)).isEqualTo(1);
		assertThat(report.countOfResult(LottoResult.WIN_1ST)).isEqualTo(1);
	}
}