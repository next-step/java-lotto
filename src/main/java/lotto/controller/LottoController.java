package lotto.controller;

import java.util.List;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.PurchaseLottoGroup;
import lotto.domain.RankingResult;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	public long calculateLottoQuantity(Amount purchaseAmount) {
		long lottoQuantity = purchaseAmount.divide(Lotto.LOTTO_PRICE);

		OutputView.printPurchaseQuantity(lottoQuantity);
		return lottoQuantity;
	}

	public PurchaseLottoGroup purchaseLotto() {
		long lottoQuantity = calculateLottoQuantity(InputView.inputPurchaseAmount());
		PurchaseLottoGroup purchaseLottoGroup = new PurchaseLottoGroup(lottoQuantity);

		OutputView.printPurchaseLottoGroup(purchaseLottoGroup);
		return purchaseLottoGroup;
	}

	public void ranking(PurchaseLottoGroup purchaseLottoGroup) {
		WinningNumber winningNumber = InputView.inputWinningNumber();
		RankingResult rankingResult = new RankingResult(purchaseLottoGroup, winningNumber);

		OutputView.printWinningStatistics(rankingResult);
		OutputView.printYield(rankingResult.calculateRoi());
	}
}