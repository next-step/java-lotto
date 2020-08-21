package lotto.domain;

import java.util.Collections;

import static lotto.domain.LottoNumberFactory.getLottoNumberPool;

public class LottoGameFactory {

	private LottoGameFactory() {}

	public static LottoGame getNewLottoGame() {
		Collections.shuffle(getLottoNumberPool());
		return new LottoGame(getLottoNumberPool());
	}
}
