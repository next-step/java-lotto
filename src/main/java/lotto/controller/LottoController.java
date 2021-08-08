package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoPurchase;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.WinPrizes;
import lotto.service.PrizeStatus;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {

	public static void main(String[] args) {
		Money money = new Money(LottoInputView.buyLottos());

		Lottos lottos = LottoPurchase.buyLottos(money);

		LottoOutputView.printLottoCount(money);
		LottoOutputView.printLottoList(lottos);

		Lotto winnerLotto = new Lotto(LottoInputView.inputLastWinningLotto());

		WinPrizes winPrizes = PrizeStatus.findWinPrize(lottos, winnerLotto);
		LottoOutputView.displayLottoPrize(winPrizes);
	}
}
