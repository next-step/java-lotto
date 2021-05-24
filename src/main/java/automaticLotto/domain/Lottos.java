package automaticLotto.domain;

import java.util.List;

public class Lottos {
	private static final int MAXIMUM_LOTTOS_SIZE = 100;

	private final List<Lotto> lottos;

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
		validateLottosSize();
	}

	private void validateLottosSize() {
		if (lottos.size() > MAXIMUM_LOTTOS_SIZE) {
			throw new RuntimeException("the size of lottos can not exceed 100");
		}
	}

	public int size() {
		return this.lottos.size();
	}

	public WinnerTable announce(Lotto winnerLotto) {
		WinnerTable winnerTable = new WinnerTable();

		for (Lotto lotto : lottos) {
			winnerTable.count(lotto.match(winnerLotto));
		}

		return winnerTable;
	}

	public List<Lotto> getLottos() {
		return this.lottos;
	}
}
