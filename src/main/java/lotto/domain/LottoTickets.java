package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.domain.strategy.GenerateStrategy;

public class LottoTickets {
	private List<LottoTicket> lottoTickets = new ArrayList<>();
	private final LinkedHashMap<Rank, Integer> result = new LinkedHashMap<>();

	public LottoTickets(int ticketQuantity, GenerateStrategy strategy) {
		for (int i = 0; i < ticketQuantity; i++) {
			lottoTickets.add(new LottoTicket(strategy));
		}
		for (Rank rank : Rank.values()) {
			result.put(rank, 0);
		}
	}

	public LottoTickets(List<LottoTicket> lottoTickets) {
		this.lottoTickets = lottoTickets;
	}

	public List<LottoTicket> getLottoTickets() {
		return Collections.unmodifiableList(lottoTickets);
	}

	public LinkedHashMap<Rank, Integer> validTicket(LottoValidator lottoValidator) {
		List<Rank> ranks =  lottoTickets.stream()
			.map(lottoValidator::valid)
			.collect(Collectors.toList());

		for (Rank rank : ranks) {
			result.put(rank, result.get(rank) + 1);
		}
		return result;
	}

	// bigDecimal?
	public double calcReturnRate(int totalAmount) {
		return calcTotalAmount() / totalAmount;
	}

	private long calcTotalAmount() {
		long sum = 0;
		for (Map.Entry<Rank, Integer> result : result.entrySet()) {
			sum += result.getKey().getAmount() * result.getValue();
		}
		return sum;
	}
}
