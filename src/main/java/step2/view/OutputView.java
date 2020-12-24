package step2.view;

import java.util.List;

import step2.domain.Lotto;
import step2.domain.LottoProfit;
import step2.domain.LottoPurchase;
import step2.domain.LottoResults;
import step2.domain.LottoWin;

public class OutputView {

	private final String SPACE = " ";
	private final String NEW_LINE = "\n";

	public void printLottos(final List<Lotto> lottos) {
		lottos.forEach(System.out::println);
		System.out.println();
	}

	public void printWinResult(final LottoResults lottoResults) {
		final String messageOfWinStatisticTitle = "당첨 통계";


		final StringBuilder statisticOutputBuilder = new StringBuilder();
		statisticOutputBuilder.append(messageOfWinStatisticTitle).append(NEW_LINE)
			.append("---------").append(NEW_LINE);

		for (LottoWin lottoWin : LottoWin.values()) {
			append(statisticOutputBuilder, lottoWin, lottoResults.get(lottoWin));
		}

		statisticOutputBuilder.setLength(statisticOutputBuilder.length() - 1);

		System.out.println(statisticOutputBuilder.toString());
	}

	private void append(final StringBuilder statisticOutputBuilder, LottoWin lottoWin, Integer winCount) {
		if (!lottoWin.isWin()) {
			return;
		}
		final String messageFormatMatchCount = "%d개 일치";
		final String messageFormatPrice = "(%d원)";
		final String messageFormatWinCount = "%d개";
		final String PRICE_WIN_COUNT_DELIMITER = "- ";

		statisticOutputBuilder
			.append(String.format(messageFormatMatchCount, lottoWin.getMatchCount()));

		if (lottoWin.isWinWithBonusBall()) {
			statisticOutputBuilder.append(", 보너스 볼 일치");
		}

		statisticOutputBuilder
			.append(SPACE)
			.append(String.format(messageFormatPrice, lottoWin.getPrice()))
			.append(PRICE_WIN_COUNT_DELIMITER)
			.append(String.format(messageFormatWinCount, winCount == null ? 0 : winCount))
			.append(NEW_LINE);

	}

	public void printProfitRatio(final LottoProfit lottoProfit) {
		final Long PROFIT_CRITERIA = 1L;
		final String messageFormatProfitRatio = "총 수익률은 %.2f입니다.";
		final StringBuilder profitOutputBuilder = new StringBuilder();
		final Double profitRatio = lottoProfit.getProfitRatio();

		profitOutputBuilder.append(String.format(messageFormatProfitRatio, profitRatio));

		if (profitRatio < PROFIT_CRITERIA) {
			profitOutputBuilder.append(String.format("(기준이 %d이기 때문에 결과적으로는 손해라는 의미임)",
				PROFIT_CRITERIA));
		}

		profitOutputBuilder.append(String.format("(기준이 %d이기 때문에 결과적으로는 이익이라는 의미임)",
			PROFIT_CRITERIA));

		System.out.println(profitOutputBuilder.toString());
	}

	public void printLottoCount(final LottoPurchase lottoPurchase) {
		final String messageOfResultPurchasePrice = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
		System.out.printf((messageOfResultPurchasePrice) + "%n", lottoPurchase.getManualLottoCount(),
			lottoPurchase.getAutoLottoIssueCount());
	}

}
