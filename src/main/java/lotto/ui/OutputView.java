package lotto.ui;

import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;

import java.util.List;

public class OutputView {
	private static final String BUY_COUNT_FORMAT = "%d개를 구매했습니다.";
	private static final String STATISTIC_START_MSG = "당첨 통계\n--------";
	private static final String STATISTIC_RANK_FORMAT = "%d개 일치 (%,d원)- %d개";
	private static final String STATISTIC_YIELD_FORMAT = "총 수익률은 %.2f입니다.";

	public static OutputView getInstance() {
		return new OutputView();
	}

	public void printLottoNumbers(List<LottoNumber> lottoNumbers) {
		System.out.println(String.format(BUY_COUNT_FORMAT, lottoNumbers.size()));
		lottoNumbers.forEach(System.out::println);
		System.out.println();
	}

	public void printStatistics(LottoResult lottoResult) {
		System.out.println(STATISTIC_START_MSG);

		lottoResult.getWinningMap()
				.forEach((lottoRank, count) -> {
					System.out.println(String.format(STATISTIC_RANK_FORMAT, lottoRank.getCorrectNumbers(), lottoRank.getEarningPrize(), count));
				});

		System.out.println(String.format(STATISTIC_YIELD_FORMAT, lottoResult.getYield()));
	}

}
