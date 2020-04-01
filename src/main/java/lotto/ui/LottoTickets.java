package lotto.ui;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
	private final List<LottoTicket> lottoTickets;

	public LottoTickets(List<LottoTicket> lottoTickets) {
		this.lottoTickets = Collections.unmodifiableList(lottoTickets);
	}

	public List<List<Integer>> getLottoTickets() {
		return lottoTickets.stream()
				.map(LottoTicket::getLottoNumbers)
				.collect(Collectors.toList());
	}
}
