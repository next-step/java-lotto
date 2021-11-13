package lotto.domain;

import java.util.List;
import java.util.Objects;

import lotto.generator.Generator;

public class Lotto {
	private final Tickets tickets;

	private Lotto(Generator generator, int sizeOfAutoTickets, List<Ticket> manualTickets) {
		this(Tickets.create(generator, sizeOfAutoTickets, manualTickets));
	}

	private Lotto(Tickets tickets) {
		this.tickets = tickets;
	}

	public static Lotto create(Generator generator, int sizeOfAutoTickets, List<Ticket> manualTickets) {
		return new Lotto(generator, sizeOfAutoTickets, manualTickets);
	}

	public List<Ticket> getTickets() {
		return tickets.getValues();
	}

	public Statistics createStatistics(WinningTicket winningTicket) {
		return Statistics.create(tickets, winningTicket);
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
