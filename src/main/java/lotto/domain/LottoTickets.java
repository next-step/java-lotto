package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

	private List<LottoTicket> lottoTickets;

	private LottoTickets(List<LottoTicket> lottoTickets) {
		this.lottoTickets = lottoTickets;
	}

	public static LottoTickets from(List<LottoTicket> lottoTickets) {
		return new LottoTickets(lottoTickets);
	}

	public List<LottoPrize> getLottoPrizes(LottoTicket winningLottoTicket) {
		return lottoTickets.stream()
				.map(lottoTicket -> lottoTicket.compareTo(winningLottoTicket))
				.collect(Collectors.toList());
	}

	public List<LottoTicket> getLottoTickets() {
		return lottoTickets;
	}
}
