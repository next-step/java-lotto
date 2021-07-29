package lotto.domain;

import java.util.List;

public class LottoTickets {

	private List<LottoTicket> lottoTickets;

	private LottoTickets(List<LottoTicket> lottoTickets) {
		this.lottoTickets = lottoTickets;
	}

	public static LottoTickets from(List<LottoTicket> lottoTickets) {
		return new LottoTickets(lottoTickets);
	}

	public List<LottoTicket> getLottoTickets() {
		return lottoTickets;
	}
}
