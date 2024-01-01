package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class WinningLotto {
	private final Lotto winningLotto;
	private final LottoNumber bonus;

	public WinningLotto(final Lotto winningLotto, final LottoNumber bonus) {
		this.winningLotto = winningLotto;
		this.bonus = bonus;
	}

	public List<MatchingNumbers> match(final Ticket ticket) {
		List<MatchingNumbers> matchingNumbersList = new ArrayList<>();
		MatchingNumbers matchingNumbers;

		for (int i = 0; i < ticket.ticket().size(); i++) {
			matchingNumbers = new MatchingNumbers(compareTo(ticket, i), containsBonus(ticket, i));
			matchingNumbersList.add(matchingNumbers);
		}

		return matchingNumbersList;
	}

	private int compareTo(final Ticket ticket, final int index) {
		return contains(ticket.ticket().get(index));
	}

	private int contains(final Lotto lotto) {
		int count = 0;

		for (LottoNumber winningNumber : winningLotto.lotto()) {
			for (LottoNumber lottoNumber : lotto.lotto()) {
				if (winningNumber.equals(lottoNumber)) {
					count++;
				}
			}
		}

		return count;
	}

	private Boolean containsBonus(final Ticket ticket, final int index) {
		for (LottoNumber lottoNumber : ticket.ticket().get(index).lotto()) {
			if (lottoNumber.equals(bonus)) {
				return true;
			}
		}

		return false;
	}
}
