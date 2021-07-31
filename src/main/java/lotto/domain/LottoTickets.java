package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;

public class LottoTickets {

	private final List<LottoTicket> tickets;

	private LottoTickets(List<LottoTicket> tickets) {
		this.tickets = tickets;
	}

	public static LottoTickets from(List<LottoTicket> lottoTickets) {
		return new LottoTickets(Collections.unmodifiableList(lottoTickets));
	}

	public LottoPrizes getLottoPrizes(WinningLottoTicket winningLottoTicket) {
		List<LottoPrize> lottoPrizes = tickets.stream()
										.map(winningLottoTicket::match)
										.collect(collectingAndThen(toList(), Collections::unmodifiableList));
		return LottoPrizes.from(lottoPrizes);
	}

	public List<LottoTicket> getTickets() {
		return Collections.unmodifiableList(tickets);
	}
}
