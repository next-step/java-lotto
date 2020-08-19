package step3.domain;

import java.util.Collections;

import static step3.domain.LottoNumberFactory.getLottoNumberPool;

public class LottoGameFactory {

	private LottoGameFactory() {}

	public static LottoGame getNewLottoGame() {
		Collections.shuffle(getLottoNumberPool());
		return new LottoGame(getLottoNumberPool());
	}
}
