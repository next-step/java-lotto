package lotto.view;

import static java.lang.System.*;

import java.text.MessageFormat;

import lotto.domain.Reward;
import lotto.view.dto.LottoStringsDto;
import lotto.view.dto.PurchaseCountDto;
import lotto.view.dto.WinningStatisticDto;

public class ResultView {
	private static final String PURCHASE_COUNT_FORMAT = "{0}개를 구매하였습니다.";
	private static final String STATISTIC_TITLE = "당첨 통계";
	private static final String UNDER_LINE = "----------";
	private static final String STATISTIC_FORMAT = "{0}개 일치 ({1}원)- {2}개";
	private static final String PERFORMANCE_FORMAT = "총 수익률은 {0}입니다.";

	private static final String LINE_BREAK = "\n";

	public void printPurchaseCount(PurchaseCountDto purchaseCountDto) {
		print(MessageFormat.format(PURCHASE_COUNT_FORMAT, purchaseCountDto.getPurChaseCount()));
		print(LINE_BREAK);
	}

	public void printLottosString(LottoStringsDto lottosStringDto) {
		for (int i = 0; i < lottosStringDto.getLottoStrings().size(); i++) {
			print(lottosStringDto.getLottoStrings().get(i));
			print(LINE_BREAK);
		}
	}

	public void printWinningStatistic(WinningStatisticDto winningStatisticDto) {
		print(STATISTIC_TITLE + LINE_BREAK + UNDER_LINE + LINE_BREAK);

		for (int matchingCount = WinningStatisticDto.MIN_MATCHING_COUNT;
			 matchingCount <= WinningStatisticDto.MAX_MATCHING_COUNT; matchingCount++) {
			final int rewardMoney = Reward.getRewardByMatchCount(matchingCount).getMoney();
			final int count = winningStatisticDto.getWinningStatistic().getOrDefault(matchingCount, 0);

			print(MessageFormat.format(STATISTIC_FORMAT, matchingCount, rewardMoney, count));
			print(LINE_BREAK);
		}

		print(
			MessageFormat.format(PERFORMANCE_FORMAT, String.format("%.2f", winningStatisticDto.getPerformance())));
		print(LINE_BREAK);
	}

	public void printExceptionMessage(Exception exception) {
		print(exception.getMessage());
	}

	private void print(String text) {
		out.print(text);
	}
}
