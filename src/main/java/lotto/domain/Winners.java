package lotto.domain;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public final class Winners {
	private final List<Lotto> winners;

	public Winners(final List<Lotto> winners) {
		this.winners = winners;
	}

	public List<Lotto> winners() {
		return winners;
	}

	public int countWinningNumbers(final List<Lotto> lottos) {
		int count = 0;
		for (Lotto winningLotto : winners) {
			for (Lotto lotto : lottos) {
				if (winningLotto.equals(lotto)) {
					count++;
				}
			}
		}

		return count;
	}

	public static List<Lotto> winningNumbers(final Set<Lotto> lottos) {
		EnumSet<Lotto> winningNumbers = EnumSet.copyOf(lottos);
		return new ArrayList<>(winningNumbers);
	}
}
