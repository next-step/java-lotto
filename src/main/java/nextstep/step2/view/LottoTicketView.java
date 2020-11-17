package nextstep.step2.view;

import nextstep.step2.domain.Lotto;

import java.util.List;

public class LottoTicketView {

	public void printLottoTickets(List<Lotto> lottos) {
		StringBuilder sb = new StringBuilder();
		lottos.forEach(lotto -> sb.append(lotto.getNumbers().toString()).append("\n"));
		System.out.println(sb.toString());
	}
}
