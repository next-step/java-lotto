package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.LastWeekWinnerNumber;
import lotto.domain.Lotteries;
import lotto.domain.Lotto;
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
			int purchaseManualNumber = getManualNumberSize();
			validateManualNumber(purchasePrice, purchaseManualNumber);
			List<String> manualNumbers = getManualNumber(purchaseManualNumber);
			Lotteries lotteries = getLottoGames(purchasePrice, manualNumbers);
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

	private static int getManualNumberSize() {
		InputView inputPurchaseManualPriceView = new InputView("수동으로 구매할 로또 수를 입력해 주세요.");
		return inputPurchaseManualPriceView.getInputInt();
	}

	private void validateManualNumber(int purchasePrice, int purchaseManualNumber) {
		int totalPurchaseManualNumber = purchaseManualNumber * Lotteries.PRICE_PER_GAME;
		if (totalPurchaseManualNumber > purchasePrice) {
			throw new IllegalArgumentException("수동으로 구입할 수 있는 금액이 초과했습니다.");
		}
	}

	private static List<String> getManualNumber(int purchaseManualNumber) {
		InputView inputPurchaseManualNumberView = new InputView("수동으로 구매할 번호를 입력해 주세요.");
		List<String> purchaseManualNumbers = new ArrayList<>();
		for (int i = 0; i < purchaseManualNumber; i++) {
			purchaseManualNumbers.add(inputPurchaseManualNumberView.getInputString());
		}
		return purchaseManualNumbers;
	}

	private static Lotteries getLottoGames(int purchasePrice, List<String> manualNumbers) {
		int autoPurchasePrice = calculateAutoPurchasePrice(purchasePrice, manualNumbers.size());
		Lotteries totalLotteries = new Lotteries(
			manualNumbers.stream().map(manualNumber -> new Lotto(manualNumber)).toArray(Lotto[]::new));

		if (autoPurchasePrice > Lotteries.PRICE_PER_GAME) {
			totalLotteries.add(new Lotteries(autoPurchasePrice));
		}

		ResultView resultView = new ResultView();
		resultView.printLottoGameList(totalLotteries.getLottoGameList(), purchasePrice, manualNumbers.size());
		return totalLotteries;
	}

	private static int calculateAutoPurchasePrice(int purchasePrice, int size) {
		return purchasePrice - (size * Lotteries.PRICE_PER_GAME);
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
