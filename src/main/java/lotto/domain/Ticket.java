package lotto.domain;

import java.util.List;

public final class Ticket {
	private final List<Lottos> ticket;

	public Ticket(final List<Lottos> ticket) {
		this.ticket = ticket;
	}

	public List<Lottos> ticket() {
		return ticket;
	}

	public int compareTo(final int[] winningNumbers, final int index) {
		return ticket.get(index).contains(winningNumbers);
	}
}
