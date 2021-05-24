package lotto.view;

import lotto.Constants;
import lotto.LottoResult;
import lotto.Lottos;

public class ResultView {
	public static void printBoughtLottos(Lottos lottos) {
		System.out.println(lottos.numberOfBoughtLottos() + Constants.PRINT_NUMBER_OF_BOUGHT_LOTTOS);
		System.out.println(lottos);
	}

	public static void printWinningStatistics(LottoResult lottoResult) {
		System.out.println(Constants.PRINT_STATISTICS);
		System.out.println(lottoResult.toString());
		System.out.println(Constants.PRINT_PROFIT_RATE(lottoResult.getProfitRate()));
	}
}
