package nextstep.step2.view;

import nextstep.step2.domain.Lotto;

import java.util.List;

public class LottoTicketView {
	private List<Lotto> lottos;

	public LottoTicketView(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public void printLottoTickets() {
		StringBuilder sb = new StringBuilder();
		lottos.forEach(lotto -> sb.append(lotto.getNumbers().toString()).append("\n"));
		System.out.println(sb.toString());
	}
}
