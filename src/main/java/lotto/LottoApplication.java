package lotto;

import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
	public static void main(String[] args) {
		int amount = InputView.inputAmount();
		Lottos lottos = new Lottos(amount);

		ResultView.outputPurchaseLotto(lottos);
	}
}
