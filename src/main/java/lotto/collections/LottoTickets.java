package lotto.collections;

import java.util.List;

public class LottoTickets {

	private List<LottoTicket> lottoTickets;

	public LottoTickets(List<LottoTicket> lottoTickets) {
		this.lottoTickets = lottoTickets;
	}

	public int numberOfLottoTickets() {
		return lottoTickets.size();
	}

	public List<LottoTicket> getLottoTickets() {
		return lottoTickets;
	}
}
