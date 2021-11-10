package lotto.view;

import java.util.Arrays;
import java.util.List;

import lotto.domain.Rank;
import lotto.domain.Statistics;
import lotto.domain.Ticket;
import lotto.exception.UtilCreationException;

public final class ResultView {
	private ResultView() {
		throw new UtilCreationException();
	}

	public static void printTickets(List<Ticket> tickets) {
		tickets.forEach(System.out::println);
	}

	public static void printStatistics(Statistics statistics) {
		System.out.println("\n당첨 통계");
		System.out.println("---------");

		Rank[] ranksWithoutMiss = Arrays.stream(Rank.values())
			.filter(rank -> rank != Rank.MISS)
			.toArray(Rank[]::new);

		for (Rank rank : ranksWithoutMiss) {
			System.out.printf("%d개 일치 (%d원)- %d개\n", rank.getCountOfMatch(), rank.getWinningMoney(),
				statistics.getRankMatchedCount(rank));
		}

		double profitRatio = statistics.calculateProfitRatio();
		System.out.printf("총 수익률은 %.2f 입니다.", profitRatio);
		System.out.printf(" (기준이 1이기 때문에 결과적으로 '%s'(이)라는 의미임)\n", getProfitResult(profitRatio));
	}

	private static String getProfitResult(double profitRatio) {
		if (profitRatio > 1) {
			return "이익";
		}
		if (profitRatio < 1) {
			return "손해";
		}
		return "동일";
	}
}
