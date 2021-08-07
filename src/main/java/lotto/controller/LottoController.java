package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoPurchase;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.WinPrizes;
import lotto.service.SearchPrize;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {

	public static void main(String[] args) {
		Money money = LottoInputView.buyLottos();

		Lottos lottos = LottoPurchase.buyLottos(money);

		LottoOutputView.printLottoCount(money);
		LottoOutputView.printLottoList(lottos);

		Lotto lastWinningLotto = LottoInputView.inputLastWinningLotto();

		WinPrizes winPrizes = SearchPrize.drawWinPrize(lottos, lastWinningLotto);
		LottoOutputView.displayLottoPrize(winPrizes);
	}
}
