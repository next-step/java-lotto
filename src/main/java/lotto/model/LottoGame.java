package lotto.model;

import java.util.Collections;
import java.util.List;

public class LottoGame {

	private final List<Lotto> lottoGame;

	public LottoGame(List<Lotto> lottoGame) {
		this.lottoGame = Collections.unmodifiableList(lottoGame);
	}

	public List<Lotto> getLottoGame() {
		return lottoGame;
	}
}
