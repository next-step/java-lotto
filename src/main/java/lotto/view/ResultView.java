package lotto.view;

import java.util.List;

import lotto.domain.LottoTicket;

public class ResultView {
	public void showHowManyBuyTicket(int num) {
		StringBuilder sb = new StringBuilder();
		sb.append(num);
		sb.append("개 를 구매했습니다.");
		System.out.println(sb);
	}

	public void showLottoTickets(List<LottoTicket> lottoTickets) {
		for (LottoTicket ticket : lottoTickets) {
			showLottoTicket(ticket);
		}
	}
	private void showLottoTicket(LottoTicket ticket) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < ticket.getNumbersToList().size(); i++) {
			sb.append(ticket.getNumbersToList().get(i));
			// StringBuilder를 넘겨받아 indent를 줄이는 것이 좋을까?
			if (i != ticket.getNumbersToList().size() - 1)
				sb.append(", ");
		}
		sb.append("]");
		System.out.println(sb);
	}
}
