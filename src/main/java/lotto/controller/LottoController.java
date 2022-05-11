package lotto.controller;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.PurchaseLottoGroup;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

	public void play() {
		// 14000
		Amount purchaseAmount = InputView.inputPurchaseAmount();

		long lottoQuantity = purchaseAmount.divide(Lotto.LOTTO_PRICE);
		PurchaseLottoGroup purchaseLottoGroup = new PurchaseLottoGroup(lottoQuantity);

		OutputView.printPurchaseQuantity(lottoQuantity);
		OutputView.printPurchaseLottoGroup(purchaseLottoGroup);

		WinningNumber winningNumber = InputView.inputWinningNumber();
	}
}