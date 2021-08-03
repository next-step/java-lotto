package lotto.model;

import java.util.Collections;
import java.util.List;

public class LottoGames {

	private final List<LottoGame> lottoGames;

	public LottoGames(List<LottoGame> lottoGames) {
		this.lottoGames = lottoGames;
	}

	public List<LottoGame> getLottoGames() {
		return Collections.unmodifiableList(lottoGames);
	}
}
