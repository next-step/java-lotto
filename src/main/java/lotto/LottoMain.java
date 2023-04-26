package lotto;

import java.util.List;

import lotto.domain.LottoMachine;
import lotto.domain.PrizeSituation;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoMain {

	public static void main(String[] args) {
		long purchaseAmount = InputView.inputPurchaseAmount();
		LottoMachine lottoMachine = new LottoMachine(purchaseAmount);
		ResultView.printPurchasedCount(lottoMachine.purchasedCount());
		ResultView.printCurrentSituation(lottoMachine.selectLottoNumbers());
		lottoMachine.calculateScore(InputView.inputWinNumbers());
		List<PrizeSituation> prizeSituations = lottoMachine.makePrizeSituations();
		ResultView.printPrizeSituations(lottoMachine.sortInOrderScore(prizeSituations));

		long totalProfit = lottoMachine.totalProfit(prizeSituations);
		double totalProfitRate = lottoMachine.totalProfitRate(totalProfit, purchaseAmount);
		boolean benefit = lottoMachine.isBenefit(totalProfitRate);
		ResultView.printTotalProfitRate(totalProfitRate, benefit);
	}
}
