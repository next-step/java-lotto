package lotto.view;

import static java.lang.System.*;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Reward;
import lotto.view.dto.LottoStringsDto;
import lotto.view.dto.PurchaseCountDto;
import lotto.view.dto.WinningStatisticDto;

public class ResultView {
	private static final String PURCHASE_COUNT_FORMAT = "{0}개를 구매하였습니다.";
	private static final String STATISTIC_TITLE = "당첨 통계";
	private static final String UNDER_LINE = "----------";
	private static final String STATISTIC_FORMAT = "{0}개 일치 ({1}원)- {2}개";
	private static final String SECOND_STATISTIC_FORMAT = "{0}개 일치 보너스 볼 일치 ({1}원)- {2}개";
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

		List<Reward> printRewards = Arrays.stream(Reward.values())
			.filter(reward -> reward != Reward.MISS)
			.collect(Collectors.toList());

		for (Reward reward : printRewards) {
			final int matchingCount = reward.getMatchCount();
			final int rewardMoney = reward.getMoney();
			final int count = winningStatisticDto.getWinningStatistic().getOrDefault(reward, 0);

			print(MessageFormat.format(getStatisticFormat(reward), matchingCount, rewardMoney, count));
			print(LINE_BREAK);
		}

		print(
			MessageFormat.format(PERFORMANCE_FORMAT, String.format("%.2f", winningStatisticDto.getPerformance())));
		print(LINE_BREAK);
	}

	private String getStatisticFormat(Reward reward) {
		if (reward == Reward.SECOND) {
			return SECOND_STATISTIC_FORMAT;
		}
		return STATISTIC_FORMAT;
	}

	public void printExceptionMessage(Exception exception) {
		print(exception.getMessage());
	}

	private void print(String text) {
		out.print(text);
	}
}
