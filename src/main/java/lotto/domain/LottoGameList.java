package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGameList {
	private final List<LottoGame> lottoGameList = new ArrayList<>();

	public LottoGameList() {
	}

	public LottoGameList(int gameSize) {
		for (int i = 0; i < gameSize; i++) {
			addLottoGame(new LottoGame(new ShuffleMakeStrategy()));
		}
	}

	public void addLottoGame(LottoGame lottoGame) {
		lottoGameList.add(lottoGame);
	}

	public List<LottoGame> getLottoGameList() {
		return lottoGameList;
	}
}
