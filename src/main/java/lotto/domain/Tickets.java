package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import lotto.generator.Generator;

public class Tickets {
	private static final String EMPTY_MESSAGE = "Ticket 리스트가 비어있습니다.";

	private final List<Ticket> values;

	Tickets(List<Ticket> values) {
		validate(values);
		this.values = new ArrayList<>(values);
	}

	private void validate(List<Ticket> values) {
		if (isEmpty(values)) {
			throw new IllegalArgumentException(EMPTY_MESSAGE);
		}
	}

	private boolean isEmpty(List<Ticket> values) {
		return values == null || values.size() == 0;
	}

	public static Tickets create(List<Ticket> values) {
		return new Tickets(values);
	}

	public static Tickets create(Generator generator, int numberOfPurchases) {
		List<Ticket> values = new ArrayList<>();
		for (int i = 0; i < numberOfPurchases; i++) {
			values.add(Ticket.create(generator.generate()));
		}
		return create(values);
	}

	public List<Ticket> getValues() {
		return Collections.unmodifiableList(values);
	}

	public int getRankMatchedCount(Rank rank, Ticket winningNumberTicket) {
		return (int)values.stream()
			.map(ticket -> ticket.getMatchedCount(winningNumberTicket))
			.filter(matchedCount -> matchedCount == rank.getCountOfMatch())
			.count();
	}

	public double calculateProfitRatio(Ticket winningNumberTicket) {
		double winningAmount = values.stream()
			.map(ticket -> Rank.from(ticket.getMatchedCount(winningNumberTicket)))
			.mapToDouble(Rank::getWinningMoney)
			.sum();

		int purchasePrice = values.size() * Ticket.PRICE;
		return winningAmount / purchasePrice;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Tickets tickets = (Tickets)obj;

		return Objects.equals(values, tickets.values);
	}

	@Override
	public int hashCode() {
		return values != null ? values.hashCode() : 0;
	}
}
