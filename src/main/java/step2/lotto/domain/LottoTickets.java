package step2.lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import step2.lotto.LottoRandomNumberGenerator;

public class LottoTickets {

	private List<LottoTicket> lottoTickets;

	public LottoTickets(List<LottoTicket> lottoTickets) {
		this.lottoTickets = lottoTickets;
	}

	public static LottoTickets create() {
		return new LottoTickets(new ArrayList());
	}

	public static LottoTickets from(List<LottoTicket> lottoTickets) {
		return new LottoTickets(lottoTickets);
	}

	public static LottoTickets of(LottoTicket ...lottoTickets) {
		return new LottoTickets(Arrays.asList(lottoTickets));
	}

	public void add() {
		lottoTickets.add(LottoTicket.from(LottoRandomNumberGenerator.create()));
	}

	public void add(LottoTicket ...lottoTickets) {
		Arrays.stream(lottoTickets)
			.forEach(lottoTicket -> this.lottoTickets.add(lottoTicket));
	}

	public int getSize() {
		return lottoTickets.size();
	}

	public List<LottoTicket> getLottoTickets() {
		return lottoTickets;
	}

	public int countMatchedTicket(LottoTicket lottoTicket, int targetCount) {
		return (int)lottoTickets.stream()
			.filter(ticket -> ticket.countMatch(lottoTicket) == targetCount)
			.count();
	}
}
