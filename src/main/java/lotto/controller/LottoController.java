package lotto.controller;

import lotto.domain.LastWeekWinnerNumber;
import lotto.domain.LottoGames;
import lotto.domain.RankingResult;
import lotto.domain.RateOfReturn;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

	private final static int PRICE_PER_GAME = 1000;
	private RankingResult rankingResult;
	private double rateOfReturn;

	public LottoController() {
	}

	public void run() {
		try {
			int purchasePrice = getPrice();
			validationLottoGamesSize(purchasePrice / PRICE_PER_GAME);
			LottoGames lottoGames = getLottoGames(purchasePrice / PRICE_PER_GAME);
			rankingResult = getRankingResult(lottoGames);
			rateOfReturn = getRateOfReturn(purchasePrice, rankingResult);

			printStatus(rankingResult, rateOfReturn);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static int getPrice() {
		InputView inputPurchasePriceView = new InputView("구입 금액을 입력해주세요.");
		return inputPurchasePriceView.getInputInt();
	}

	private static LottoGames getLottoGames(int gamesSize) {
		validationLottoGamesSize(gamesSize);
		LottoGames lottoGames = new LottoGames(gamesSize);
		ResultView resultView = new ResultView();
		resultView.printLottoGameList(lottoGames.getLottoGameList());
		return lottoGames;
	}

	private static RankingResult getRankingResult(LottoGames lottoGames) {
		InputView inputLastWeekWinnerView = new InputView("지난 주 당첨 번호를 입력해주세요.");
		String lastWeekWinnerNumberInput = inputLastWeekWinnerView.getInputString();

		LastWeekWinnerNumber lastWeekWinnerNumber = new LastWeekWinnerNumber(lastWeekWinnerNumberInput);
		RankingResult rankingResult = new RankingResult();
		rankingResult.calculate(lottoGames, lastWeekWinnerNumber);
		return rankingResult;
	}

	private static double getRateOfReturn(int purchasePrice, RankingResult rankingResult) {
		RateOfReturn rateOfReturn = new RateOfReturn();
		return rateOfReturn.calculate(rankingResult.getResult(), purchasePrice);
	}

	private static void printStatus(RankingResult rankingResult, double rateOfReturn) {
		if (rankingResult != null) {
			ResultView resultView = new ResultView();
			resultView.printStatus(rankingResult, rateOfReturn);
		}
	}

	private static void validationLottoGamesSize(int gameSize) {
		if (gameSize < 1) {
			throw new IllegalArgumentException("최소 한장 이상 구매할 수 있는 금액을 입력해주세요.");
		}
	}
}
