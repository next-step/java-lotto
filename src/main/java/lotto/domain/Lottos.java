package lotto.domain;

import java.util.List;
import java.util.function.Consumer;

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

	public WinnerTable announce(WinnerLotto winnerLotto) {
		WinnerTable winnerTable = new WinnerTable();

		for (Lotto lotto : lottos) {
			winnerTable.count(winnerLotto.match(lotto));
		}

		return winnerTable;
	}

	public void forEachLottos(Consumer<Lotto> lamda) {
		lottos.forEach(lamda);
	}
}
