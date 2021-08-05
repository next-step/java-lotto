package lotto.model;

import java.util.Collections;
import java.util.List;

public class LottoGame {

	private final List<Lotto> lotteries;

	public LottoGame(List<Lotto> lotteries) {
		this.lotteries = Collections.unmodifiableList(lotteries);
	}

	public List<Lotto> getLotteries() {
		return lotteries;
	}
}
