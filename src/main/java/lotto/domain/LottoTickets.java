package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.domain.strategy.GenerateStrategy;

public class LottoTickets {
	private final List<LottoTicket> lottoTickets = new ArrayList<>();

	public LottoTickets(int ticketQuantity, GenerateStrategy strategy) {
		for (int i = 0; i < ticketQuantity; i++) {
			lottoTickets.add(new LottoTicket(strategy));
		}
	}

	public List<LottoTicket> getLottoTickets() {
		return Collections.unmodifiableList(lottoTickets);
	}

	public List<LottoTicket> validTicket(List<Integer> winningNums) {
		return lottoTickets.stream()
			.map(lt -> new LottoValidator(winningNums).valid(lt))
			.collect(Collectors.toList());
	}

	public List<WinningInfo> convertToWinningInfo() {
		return groupByRank().entrySet().stream()
			.map(r -> new WinningInfo(r.getKey(), r.getValue().intValue()))
			.collect(Collectors.toList());
	}

	private Map<Rank, Long> groupByRank() {
		return lottoTickets.stream()
			.collect(Collectors.groupingBy(LottoTicket::getRank, Collectors.counting()));
	}

	public Double calcReturnRate(Double totalAmount, int totalPrice) {
		return totalAmount / totalPrice;
	}
}
