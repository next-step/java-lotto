package lotto.view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import lotto.domain.LottoPrize;
import lotto.domain.LottoPrizes;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class ResultView {

	private static final String MESSAGE_BOUGHT_LOTTO_TICKET_COUNT = "%s개를 구매했습니다.%n";
	private static final String MESSAGE_WINNING_STATISTICS = "\n당첨 통계\n---------";
	private static final String MESSAGE_WINNING_LOTTO_TICKET_COUNT = "%d개 일치 (%,d)원- %d개%n";
	private static final String MESSAGE_TOTAL_EARNINGS_RATE = "총 수익률은 %s입니다.";
	private static final String DECIMAL_POINT = "%.2f";
	private static final String MESSAGE_LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
	private static final String MESSAGE_PROFIT = "(개이득)";
	private static final int BASE_EARNINGS_RATE = 1;

	private ResultView() {
	}

	public static void showLottoTickets(LottoTickets lottoTickets) {
		List<LottoTicket> tickets = lottoTickets.getTickets();
		System.out.printf(MESSAGE_BOUGHT_LOTTO_TICKET_COUNT, tickets.size());
		tickets.forEach(lottoTicket -> System.out.println(lottoTicket.getNumbers()));
	}

	public static void showLottoPrizes(LottoPrizes totalLottoPrizes) {
		System.out.println(MESSAGE_WINNING_STATISTICS);
		Arrays.stream(LottoPrize.values())
			.filter(lottoPrize -> lottoPrize != LottoPrize.NONE)
			.sorted(Comparator.comparingInt(LottoPrize::prizeMoney))
			.forEach(lottoPrize -> printLottoPrizePerRank(totalLottoPrizes.prizesOf(lottoPrize), lottoPrize));
	}

	public static void showEarningsRate(double earningsRate) {
		System.out.printf(MESSAGE_TOTAL_EARNINGS_RATE, String.format(DECIMAL_POINT, earningsRate));
		if (earningsRate < BASE_EARNINGS_RATE) {
			System.out.print(MESSAGE_LOSS);
			return;
		}
		System.out.print(MESSAGE_PROFIT);
	}

	private static void printLottoPrizePerRank(LottoPrizes winningPrizes, LottoPrize lottoPrize) {
		System.out.printf(MESSAGE_WINNING_LOTTO_TICKET_COUNT, lottoPrize.matchCount(), lottoPrize.prizeMoney(), winningPrizes.size());
	}

}
