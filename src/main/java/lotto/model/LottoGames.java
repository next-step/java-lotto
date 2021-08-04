package lotto.model;

import java.util.Collections;
import java.util.List;

public class LottoGames {

	private final List<LottoGame> lottoGames;

	public LottoGames(List<LottoGame> lottoGames) {
		this.lottoGames = Collections.unmodifiableList(lottoGames);
	}

	public List<LottoGame> getLottoGames() {
		return lottoGames;
	}
}
