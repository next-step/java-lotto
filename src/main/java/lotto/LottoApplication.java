package lotto;

import java.util.Map;

import lotto.domain.LastWeekWinnerNumber;
import lotto.domain.LottoGameList;
import lotto.domain.Ranking;
import lotto.domain.RankingResult;
import lotto.domain.RateOfReturn;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
	public static void main(String[] args) {
		int purchasePrice = getPrice();

		LottoGameList lottoGameList = getLottoGameList(purchasePrice / 1000);

		RankingResult rankingResult = getRankingResult(lottoGameList);

		double ror = getRor(purchasePrice, rankingResult);

		printStatus(rankingResult.getResult(), ror);

	}

	private static void printStatus(Map<Ranking, Integer> result, double ror) {
		ResultView resultView = new ResultView();
		resultView.printStatus(result, ror);
	}

	private static double getRor(int purchasePrice, RankingResult rankingResult) {
		RateOfReturn rateOfReturn = new RateOfReturn();
		double ror = rateOfReturn.calculate(rankingResult.getResult(), purchasePrice);
		return ror;
	}

	private static RankingResult getRankingResult(LottoGameList lottoGameList) {
		InputView inputLastWeekWinnerView = new InputView("지난 주 당첨 번호를 입력해주세요.");
		String lastWeekWinnerNumberInput = inputLastWeekWinnerView.getInputString();

		LastWeekWinnerNumber lastWeekWinnerNumber = new LastWeekWinnerNumber(lastWeekWinnerNumberInput);
		RankingResult rankingResult = new RankingResult();
		rankingResult.calculate(lottoGameList, lastWeekWinnerNumber);
		return rankingResult;
	}

	private static LottoGameList getLottoGameList(int gameListSize) {
		LottoGameList lottoGameList = new LottoGameList(gameListSize);
		ResultView resultView = new ResultView();
		resultView.printLottoGameList(lottoGameList.getLottoGameList());
		return lottoGameList;
	}

	private static int getPrice() {
		InputView inputPurchasePriceView = new InputView("구입 금액을 입력해주세요.");
		int purchasePrice = inputPurchasePriceView.getInputInt();
		return purchasePrice;
	}
}
