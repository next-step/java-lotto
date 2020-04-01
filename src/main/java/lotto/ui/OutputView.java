package lotto.ui;

import lotto.domain.LottoRank;
import lotto.dto.LottoNumberDto;
import lotto.dto.LottoStatisticsDto;
import lotto.dto.PurchasedLottoNumbersDto;
import lotto.utils.StringFormatter;

import java.util.Map;

public class OutputView {
	private static final String BUY_COUNT_FORMAT = "수동으로 %d장, 자동으로 %d장을 구매했습니다.";
	private static final String STATISTIC_START_MSG = "당첨 통계\n--------";
	private static final String STATISTIC_RANK_FORMAT = "%d개 일치%s(%,d원)- %d개";
	private static final String STATISTIC_RANK_BONUS_STRING = ", 보너스 볼 일치";
	private static final String STATISTIC_RANK_NOT_BONUS_STRING = " ";
	private static final String STATISTIC_YIELD_FORMAT = "총 수익률은 %.2f입니다.";

	public static OutputView getInstance() {
		return new OutputView();
	}

	public void printLottoNumbers(PurchasedLottoNumbersDto lottoNumbers) {
		System.out.println(String.format(BUY_COUNT_FORMAT, lottoNumbers.getPassiveCount(), lottoNumbers.getAutoCount()));
		lottoNumbers.getLottoNumbers().stream()
				.map(LottoNumberDto::getNumbers)
				.map(StringFormatter::listToString)
				.forEach(System.out::println);
		System.out.println();
	}

	public void printStatistics(LottoStatisticsDto lottoStatisticsDto) {
		System.out.println(STATISTIC_START_MSG);

		lottoStatisticsDto.getWinningMap()
				.entrySet()
				.forEach(this::printLottoRankEntry);

		System.out.println(String.format(STATISTIC_YIELD_FORMAT, lottoStatisticsDto.getYield()));
	}

	private void printLottoRankEntry(Map.Entry<LottoRank, Long> winningEntry) {
		System.out.println(
				String.format(STATISTIC_RANK_FORMAT,
						winningEntry.getKey().getCorrectNumbers(),
						winningEntry.getKey().hasBonus() ? STATISTIC_RANK_BONUS_STRING : STATISTIC_RANK_NOT_BONUS_STRING,
						winningEntry.getKey().getWinningMoney(),
						winningEntry.getValue()));
	}

}
