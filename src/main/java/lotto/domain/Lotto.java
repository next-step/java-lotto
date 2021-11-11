package lotto.domain;

import java.util.List;
import java.util.Objects;

import lotto.generator.Generator;

public class Lotto {
	private final Tickets tickets;

	private Lotto(Generator generator, int numberOfPurchases) {
		this(Tickets.create(generator, numberOfPurchases));
	}

	private Lotto(Tickets tickets) {
		this.tickets = tickets;
	}

	public static Lotto create(Generator generator, int numberOfPurchases) {
		return new Lotto(generator, numberOfPurchases);
	}

	public List<Ticket> getTickets() {
		return tickets.getValues();
	}

	public Statistics createStatistics(Ticket winningNumberTicket) {
		return Statistics.create(tickets, winningNumberTicket);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Lotto lotto = (Lotto)obj;

		return Objects.equals(tickets, lotto.tickets);
	}

	@Override
	public int hashCode() {
		return tickets != null ? tickets.hashCode() : 0;
	}
}
