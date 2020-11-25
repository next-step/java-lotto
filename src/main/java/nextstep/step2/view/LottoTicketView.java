package nextstep.step2.view;

import nextstep.step2.domain.Lottos;

public class LottoTicketView {

	public static void printLottoTickets(Lottos lottos) {
		StringBuilder sb = new StringBuilder();
		lottos.getLottos().forEach(lotto -> sb.append(lotto.getNumbers().toString()).append("\n"));
		System.out.println(sb.toString());
	}
}
