package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class Ticket {
	private final List<Lotto> ticket;

	public Ticket(final List<Lotto> ticket) {
		this.ticket = ticket;
	}

	public List<Lotto> ticket() {
		return ticket;
	}

	public int compareTo(final int[] winningNumbers, final int index) {
		return ticket.get(index).contains(winningNumbers);
	}

	public static List<Lotto> generate(final int number) {
		List<Lotto> entireLotto = new ArrayList<>();

		for (int i = 0; i < number; i++) {
			entireLotto.add(new Lotto(Lotto.generate()));
		}

		return entireLotto;
	}
}
