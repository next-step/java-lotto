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

	public void play() {
		Amount purchaseAmount = InputView.inputPurchaseAmount();

		long lottoQuantity = purchaseAmount.divide(Lotto.LOTTO_PRICE);
		PurchaseLottoGroup purchaseLottoGroup = new PurchaseLottoGroup(lottoQuantity);

		OutputView.printPurchaseQuantity(lottoQuantity);
		OutputView.printPurchaseLottoGroup(purchaseLottoGroup);

		WinningNumber winningNumber = InputView.inputWinningNumber();

		List<LottoRank> ranking = purchaseLottoGroup.ranking(winningNumber);

		RankingResult rankingResult = new RankingResult(ranking);

		OutputView.printWinningStatistics(rankingResult);
		OutputView.printYield(rankingResult.calculateYield());
	}
}