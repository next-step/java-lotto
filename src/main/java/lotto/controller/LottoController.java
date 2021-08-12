package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Payment;
import lotto.model.LottoPurchase;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.WinPrizes;
import lotto.model.WinnerLotto;
import lotto.service.PrizeStatus;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {

	public static void main(String[] args) {
		Money money = new Money(LottoInputView.inputLottoPurchaseMoney());

		Payment payment = new Payment(LottoInputView.inputManualLottoCount(), money);

		Lottos lottos = LottoPurchase.buyLottos(payment, LottoInputView.inputManualLottos(payment));

		LottoOutputView.printLottoCount(payment);
		LottoOutputView.printLottoList(lottos);

		WinnerLotto winnerLotto = new WinnerLotto(new Lotto(LottoInputView.inputLastWinningLotto()),
			LottoInputView.inputBonusNumber());

		WinPrizes winPrizes = PrizeStatus.findWinPrize(lottos, winnerLotto);
		LottoOutputView.displayLottoPrize(winPrizes);
	}
}
