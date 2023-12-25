package lotto.domain;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class Winners {
	private List<Lotto> winners;

	public Winners() {
		this.winners = new ArrayList<>();
	}

	public Winners(List<Lotto> winners) {
		this.winners = winners;
	}

	public List<Lotto> winners() {
		return winners;
	}

	public int countWinningNumbers(List<Lotto> lottos) {
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

	public static List<Lotto> winningNumbers(Set<Lotto> lottos) {
		EnumSet<Lotto> winningNumbers = EnumSet.copyOf(lottos);
		return new ArrayList<>(winningNumbers);
	}
}
