package lotto.controller;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberType;
import lotto.domain.PurchaseLottoGroup;
import lotto.domain.RankingResult;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

	public PurchaseLottoGroup purchaseLotto() {
		long lottoQuantity = calculateLottoQuantity(new Amount(InputView.inputPurchaseAmount()));
		PurchaseLottoGroup purchaseLottoGroup = new PurchaseLottoGroup(lottoQuantity);

		OutputView.printPurchaseLottoGroup(purchaseLottoGroup);
		return purchaseLottoGroup;
	}

	private long calculateLottoQuantity(Amount purchaseAmount) {
		long lottoQuantity = purchaseAmount.divide(Lotto.LOTTO_PRICE);

		OutputView.printPurchaseQuantity(lottoQuantity);
		return lottoQuantity;
	}

	public void ranking(PurchaseLottoGroup purchaseLottoGroup) {
		WinningNumbers winningNumbers = new WinningNumbers(
			InputView.inputWinningNumber(),
			LottoNumber.of(InputView.inputBonusNumber(), LottoNumberType.BONUS)
		);

		RankingResult rankingResult = new RankingResult(purchaseLottoGroup.ranking(winningNumbers));

		OutputView.printWinningStatistics(rankingResult);
		OutputView.printYield(rankingResult.calculateRoi());
	}
}