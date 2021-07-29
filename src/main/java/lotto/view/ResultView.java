package lotto.view;

import java.util.List;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class ResultView {

	private ResultView() {
	}

	public static void showLottoTickets(LottoTickets lottoTickets) {
		List<LottoTicket> tickets = lottoTickets.getLottoTickets();
		System.out.printf("%s개를 구매했습니다.%n", tickets.size());
		tickets.forEach(lottoTicket -> System.out.println(lottoTicket.getNumbers()));
	}

}
