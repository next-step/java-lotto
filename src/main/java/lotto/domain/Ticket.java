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

	public static List<Lotto> generate(final int number) {
		List<Lotto> entireLotto = new ArrayList<>();
		Lotto lotto = new Lotto();

		for (int i = 0; i < number; i++) {
			entireLotto.add(new Lotto(lotto.generate()));
		}

		return entireLotto;
	}
}
