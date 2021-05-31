package lotto.view;

import lotto.Constants;
import lotto.LottoResult;
import lotto.Lottos;

import java.math.BigDecimal;
import java.math.MathContext;

public class ResultView {
	public static void printNumbersOfBoughtLottos(BigDecimal receivedMoney, int manualLottosNumberToBuy) {
		System.out.println(Constants.PRINT_NUMBER_OF_BOUGHT_LOTTOS(receivedMoney.divide(Constants.LOTTO_PRICE, MathContext.DECIMAL32)
						.subtract(BigDecimal.valueOf(manualLottosNumberToBuy))
						.intValue(),
				manualLottosNumberToBuy));
	}

	public static void printBoughtLottos(Lottos lottos) {
		System.out.println(lottos);
	}

	public static void printWinningStatistics(LottoResult lottoResult) {
		System.out.println(Constants.PRINT_STATISTICS);
		System.out.println(lottoResult.toString());
		System.out.println(Constants.PRINT_PROFIT_RATE(lottoResult.getProfitRate()));
	}
}
