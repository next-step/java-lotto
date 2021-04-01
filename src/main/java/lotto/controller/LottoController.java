package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.LastWeekWinnerNumber;
import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseInfo;
import lotto.domain.RankingResult;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

	private final static InputView inputView = new InputView();

	public LottoController() {
	}

	public void run() {
		try {
			int purchasePrice = getPrice();
			int purchaseManualNumber = getManualNumberSize();
			PurchaseInfo purchaseInfo = new PurchaseInfo(purchasePrice, purchaseManualNumber);
			List<String> manualNumbers = getManualNumber(purchaseManualNumber);
			Lotteries lotteries = getLottoGames(purchaseInfo, manualNumbers);
			RankingResult rankingResult = getRankingResult(lotteries);
			printStatus(rankingResult, purchaseInfo);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static int getPrice() {
		return inputView.getInputInt("구입 금액을 입력해주세요.");
	}

	private static int getManualNumberSize() {
		return inputView.getInputInt("수동으로 구매할 로또 수를 입력해 주세요.");
	}

	private static List<String> getManualNumber(int purchaseManualNumber) {
		List<String> purchaseManualNumbers = new ArrayList<>();
		for (int i = 0; i < purchaseManualNumber; i++) {
			purchaseManualNumbers.add(inputView.getInputString((i == 0) ? "수동으로 구매할 번호를 입력해 주세요." : ""));
		}
		return purchaseManualNumbers;
	}

	private static Lotteries getLottoGames(PurchaseInfo purchaseInfo, List<String> manualNumbers) {
		int autoPurchasePrice = purchaseInfo.calculateAutoPurchasePrice();

		Lotteries totalLotteries = new Lotteries(
			manualNumbers.stream().map(manualNumber -> new Lotto(manualNumber)).toArray(Lotto[]::new));

		if (autoPurchasePrice > Lotteries.PRICE_PER_GAME) {
			totalLotteries.add(new Lotteries(autoPurchasePrice));
		}

		ResultView resultView = new ResultView();
		resultView.printLottoGameList(totalLotteries.getLottoGameList(), purchaseInfo);
		return totalLotteries;
	}

	private static RankingResult getRankingResult(Lotteries lotteries) {
		String lastWeekWinnerNumberInput = inputView.getInputString("지난 주 당첨 번호를 입력해주세요.");
		int bonusNumberInput = inputView.getInputInt("보너스 번호를 입력해주세요.");
		LastWeekWinnerNumber lastWeekWinnerNumber = new LastWeekWinnerNumber(lastWeekWinnerNumberInput,
			new LottoNumber(bonusNumberInput));
		return lotteries.calculateRanking(lastWeekWinnerNumber);
	}

	private static void printStatus(RankingResult rankingResult, PurchaseInfo purchaseInfo) {
		if (rankingResult != null) {
			ResultView resultView = new ResultView();
			resultView.printStatus(rankingResult, rankingResult.getRateOfReturn(purchaseInfo.getPurchasePrice()));
		}
	}
}
