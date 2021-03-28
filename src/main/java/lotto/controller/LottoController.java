package lotto.controller;

import lotto.domain.LastWeekWinnerNumber;
import lotto.domain.Lotteries;
import lotto.domain.LottoNumber;
import lotto.domain.RankingResult;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

	public LottoController() {
	}

	public void run() {
		try {
			int purchasePrice = getPrice();
			Lotteries lotteries = getLottoGames(purchasePrice);
			RankingResult rankingResult = getRankingResult(lotteries);
			printStatus(rankingResult, purchasePrice);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static int getPrice() {
		InputView inputPurchasePriceView = new InputView("구입 금액을 입력해주세요.");
		return inputPurchasePriceView.getInputInt();
	}

	private static Lotteries getLottoGames(int purchasePrice) {
		Lotteries lotteries = new Lotteries(purchasePrice);
		ResultView resultView = new ResultView();
		resultView.printLottoGameList(lotteries.getLottoGameList());
		return lotteries;
	}

	private static RankingResult getRankingResult(Lotteries lotteries) {
		InputView inputLastWeekWinnerView = new InputView("지난 주 당첨 번호를 입력해주세요.");
		String lastWeekWinnerNumberInput = inputLastWeekWinnerView.getInputString();

		InputView inputBonusNumberView = new InputView("보너스 번호를 입력해주세요.");
		int bonusNumberInput = inputBonusNumberView.getInputInt();
		LastWeekWinnerNumber lastWeekWinnerNumber = new LastWeekWinnerNumber(lastWeekWinnerNumberInput,
			new LottoNumber(bonusNumberInput));
		return lotteries.calculateRanking(lastWeekWinnerNumber);
	}

	private static void printStatus(RankingResult rankingResult, int purchasePrice) {
		if (rankingResult != null) {
			ResultView resultView = new ResultView();
			resultView.printStatus(rankingResult, rankingResult.getRateOfReturn(purchasePrice));
		}
	}
}
