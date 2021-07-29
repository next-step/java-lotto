package lotto.view;

import static lotto.domain.LottoPrize.*;

import java.util.List;

import lotto.domain.LottoPrize;
import lotto.domain.LottoPrizes;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class ResultView {

	private static final String MESSAGE_BOUGHT_LOTTO_TICKET_COUNT = "%s개를 구매했습니다.%n";
	private static final String MESSAGE_WINNING_STATISTICS = "당첨 통계\n---------\n";
	private static final String MESSAGE_WINNING_LOTTO_TICKET_COUNT = "%d개 일치 (%d)원- %d개%n";
	private static final String MESSAGE_TOTAL_PROFIT_RATE = "총 수익률은 %s입니다.";
	private static final String DECIMAL_POINT = "%.2f";

	private ResultView() {
	}

	public static void showLottoTickets(LottoTickets lottoTickets) {
		List<LottoTicket> tickets = lottoTickets.getLottoTickets();
		System.out.printf(MESSAGE_BOUGHT_LOTTO_TICKET_COUNT, tickets.size());
		tickets.forEach(lottoTicket -> System.out.println(lottoTicket.getNumbers()));
	}

	public static void showLottoPrizes(LottoPrizes totalLottoPrizes) {
		System.out.println(MESSAGE_WINNING_STATISTICS);
		for (LottoPrize lottoPrize : values()) {
			LottoPrizes winningPrizes = totalLottoPrizes.countOf(lottoPrize);
			printLottoPrizePerRank(winningPrizes, lottoPrize);
		}
	}

	public static void showProfitRate(double profitRate) {
		System.out.printf(MESSAGE_TOTAL_PROFIT_RATE, String.format(DECIMAL_POINT, profitRate));
	}

	private static void printLottoPrizePerRank(LottoPrizes winningPrizes, LottoPrize lottoPrize) {
		System.out.printf(MESSAGE_WINNING_LOTTO_TICKET_COUNT, lottoPrize.matchCount(), lottoPrize.prizeMoney(), winningPrizes.size());
	}

}
