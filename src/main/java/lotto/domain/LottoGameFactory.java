package lotto.domain;

import java.util.Collections;

import static lotto.domain.LottoNumberFactory.getLottoNumberPool;

public class LottoGameFactory {

	private LottoGameFactory() {}

	public static LottoGame getNewAutoGame() {
		Collections.shuffle(getLottoNumberPool());
		return new LottoGame(getLottoNumberPool());
	}

	public static LottoGame getNewManualGame(String[] numbers) {
		return new LottoGame(numbers);
	}
}
