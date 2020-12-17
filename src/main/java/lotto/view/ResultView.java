package lotto.view;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.LottoTickets;
import lotto.domain.Prize;
import lotto.domain.WinningLottoTicket;
import lotto.domain.WinningStatistics;

/**
 * @author : byungkyu
 * @date : 2020/12/15
 * @description :
 **/
public class ResultView {
	private static final BigDecimal ONE = new BigDecimal(1);

	public static void printWinningStatistics(LottoTickets lottoTickets, WinningLottoTicket winningLottoTicket) {
		System.out.println("당첨 통계");
		System.out.println("---------");

		WinningStatistics winningStatistics = new WinningStatistics(lottoTickets, winningLottoTicket);
		printWinningStatus(winningStatistics.getPrizeResult());
		printWinningAverage(winningStatistics.getWinningSummary());
	}

	private static void printWinningAverage(BigDecimal winningSummary) {
		StringBuilder sb = new StringBuilder("총 수익률은 " + winningSummary + "입니다.");
		if (winningSummary.compareTo(ONE) < 0) {
			sb.append("(기준이 1이기 때문에 결과적으로는 손해라는 의미임)");
		}
		System.out.println(sb);
	}

	private static void printWinningStatus(List<Prize> prizeResult) {
		List<Prize> sortedPrize = Arrays.stream(Prize.values())
			.sorted(Comparator.comparing(Prize::getReward))
			.collect(Collectors.toList());

		for (Prize prize : sortedPrize) {
			if (prize == Prize.NONE)
				continue;
			System.out.println(
				prize.getMatchCount() + "개 일치" + matchBonusComment(prize) + "(" + prize.getReward() + ") - "
					+ prizeResult.stream()
					.filter(result -> result.equals(prize)).count() + "개");
		}
	}

	private static String matchBonusComment(Prize prize) {
		if (prize == Prize.SECOND) {
			return ",보너스 볼 일치";
		}
		return "";
	}

}
