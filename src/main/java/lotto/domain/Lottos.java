package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {private List<Lotto> lottos;

	public Lottos() {
		this.lottos = new ArrayList<>();
	}

	public List<Lotto> createLottos(int count, NumberStrategy numberStrategy) {
		for (int i = 0; i < count; i++) {
			this.lottos.add(Lotto.createFromNumbers(numberStrategy.generateNumber()));
		}
		return this.lottos;
	}

	public List<Rank> match(WinningLotto winningLotto) {
		List<Rank> ranks = new ArrayList<>();
		for (Lotto lotto : lottos) {
			ranks.add(winningLotto.match(lotto));
		}
		return ranks;
	}
}