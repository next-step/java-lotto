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

	public List<MatchingNumbers> match(final WinningLotto winningLotto) {
		List<MatchingNumbers> matchingNumbersList = new ArrayList<>();
		MatchingNumbers matchingNumbers;

		for (int i = 0; i < ticket.size(); i++) {
			matchingNumbers = new MatchingNumbers(contains(i, winningLotto.lotto()), containsBonus(i, winningLotto.bonus()));
			matchingNumbersList.add(matchingNumbers);
		}

		return matchingNumbersList;
	}

	private int contains(final int index, final Lotto winningLotto) {
		return ticket.get(index).matchCount(winningLotto);
	}

	private int containsBonus(final int index, LottoNumber bonus) {
		return ticket.get(index).matchNumber(bonus);
	}
}
