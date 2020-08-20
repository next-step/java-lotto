package lotto.output;

import static java.util.stream.Collectors.joining;

import java.util.Map;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import lotto.Lottos;
import lotto.Ranking;
import lotto.result.Statistics;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OutputView {
	private static final String PURCHASE_COUNT_FORMAT = "%d개를 구매했습니다.";
	private static final String WINNING_STATISTICS_FORMAT = "\n당첨 통계\n---------- \n";
	private static final String RANKING_RESULT_FORMAT = "%d개 일치 (%d원) - %d개";
	private static final String EARNINGS_RATE_FORMAT = "총 수익률은 %.03f입니다.";

	public static void outputPurchaseLottos(Lottos lottos) {
		System.out.println(String.format(PURCHASE_COUNT_FORMAT, lottos.getPurchaseLottoCount()));
		System.out.println(toStringFromLottoNumbers(lottos) + "\n");
	}

	public static void outputStatistics(Statistics statistics) {
		System.out.println(WINNING_STATISTICS_FORMAT);
		printRankingResult(statistics.getWinningResult());
		printEarningsRate(statistics.getEarningsRate());
	}

	private static void printRankingResult(Map<Ranking, Integer> result) {
		result.keySet()
			  .stream()
			  .forEach(ranking -> {
				  System.out.println(String.format(RANKING_RESULT_FORMAT, ranking.getSameCount(), ranking.getPrizeMoney(), result.get(ranking)));
			  });
	}

	private static void printEarningsRate(double earningsRate) {
		System.out.println(String.format(EARNINGS_RATE_FORMAT, earningsRate));
	}

	private static String toStringFromLottoNumbers(Lottos lottos) {
		return lottos.getLottoNumbers()
					 .stream()
					 .map(lottoNumbers -> lottoNumbers.toString())
					 .collect(joining("\n"));
	}
}
