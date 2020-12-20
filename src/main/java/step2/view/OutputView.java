package step2.view;

import java.util.List;

import step2.domain.Lotto;
import step2.domain.LottoProfit;
import step2.domain.LottoResult;
import step2.domain.LottoResults;

public class OutputView {

	public void printLottos(final List<Lotto> lottos) {
		lottos.forEach(System.out::println);
		System.out.println();
	}

	public void printWinResult(final LottoResults lottoResults) {
		final String messageOfWinStatisticTitle = "당첨 통계";
		final String messageFormatMatchCount = "%d개 일치";
		final String messageFormatPrice = "(%d원)";
		final String messageFormatWinCount = "%d개";
		final String SPACE = " ";
		final String NEW_LINE = "\n";
		final String PRICE_WIN_COUNT_DELIMITER = "- ";

		final StringBuilder statisticOutputBuilder = new StringBuilder();
		statisticOutputBuilder.append(messageOfWinStatisticTitle).append(NEW_LINE)
			.append("---------").append(NEW_LINE);

		for (LottoResult lottoResult : lottoResults.getWinLottoResults()) {
			statisticOutputBuilder
				.append(String.format(messageFormatMatchCount, lottoResult.getMatchCount())).append(SPACE)
				.append(String.format(messageFormatPrice, lottoResult.getPrice())).append(PRICE_WIN_COUNT_DELIMITER)
				.append(String.format(messageFormatWinCount, lottoResult.getWinCount()))
				.append(NEW_LINE);
		}

		statisticOutputBuilder.setLength(statisticOutputBuilder.length() - 1);

		System.out.println(statisticOutputBuilder.toString());
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

}
