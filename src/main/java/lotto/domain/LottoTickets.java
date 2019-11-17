package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

	private List<LottoTicket> lottoTickets = new ArrayList<>();

	public LottoTickets(int ticketCount) {
		for (int i = 0; i < ticketCount; i++) {
			LottoTicket lottoTicket = new LottoTicket();
			lottoTickets.add(lottoTicket);
		}
	}

	public List<LottoTicket> getLottoTickets() {
		return lottoTickets;
	}

}
