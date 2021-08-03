package lotto.model;

import java.util.Collections;
import java.util.List;

public class LottoGame {

	private final List<Integer> lottoGame;

	public LottoGame(List<Integer> lottoGame) {
		this.lottoGame = lottoGame;
	}

	public List<Integer> getLottoGame() {
		Collections.sort(lottoGame);
		return Collections.unmodifiableList(lottoGame);
	}
}
