package lotto.view;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.NumberStrategy;

public class ResultView {
	private static final String BUY_LOTTO_MESSAGE = "개를 구매했습니다.";

	public void printBuyOfLotto(LottoGame lottoGame, NumberStrategy numberStrategy) {
		System.out.println(lottoGame.countOfLottos() + BUY_LOTTO_MESSAGE);

		List<Lotto> lottos = lottoGame.createLotto(numberStrategy);
		for (int i = 0; i < lottos.size(); i++) {
			System.out.println(lottos.get(i));
		}
	}
}
