package lotto.collections;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import lotto.domain.LottoTicket;

public class LottoTickets {

	private List<LottoTicket> lottoTickets;

	public LottoTickets(List<LottoTicket> lottoTickets) {
		this.lottoTickets = lottoTickets;
	}

	public int numberOfLottoTickets() {
		return lottoTickets.size();
	}

	public LottoResult calculateLottoResult(WinningNumbers numbers) {
		Map<Integer, Integer> lottoStatistics = lottoTickets.stream()
			.map(ticket -> ticket.getMatchCounts(numbers))
			.collect(Collectors
				.groupingBy(Function.identity(), Collectors.reducing(0, e -> 1, Integer::sum)));
		return new LottoResult(lottoStatistics);
	}

	public List<LottoTicket> getLottoTickets() {
		return lottoTickets;
	}
}
