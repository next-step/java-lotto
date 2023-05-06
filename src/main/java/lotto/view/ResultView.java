package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final double MINIMUM_EARNINGS_RATE_FOR_PROFIT = 1.0;

    private ResultView() {
    }

    public static void printLottoTickets(LottoTickets lottoTickets, int manualLottoCount) {
        System.out.println();
        System.out.printf("수동으로%d장, 자동으로%d개를 구매했습니다.%n", manualLottoCount, lottoTickets.findLottoTicketCount());
        List<LottoTicket> lottoTicketList = lottoTickets.getLottoTickets();
        for (LottoTicket lottoTicket : lottoTicketList) {
            printLottoTicket(lottoTicket);
        }
    }

    private static void printLottoTicket(LottoTicket lottoTicket) {
        String lottoTicketNumbersWithComma = lottoTicket.getLottoNumbers().stream()
                .map(LottoNumber::findLottoNumber)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        System.out.printf("[%s]%n", lottoTicketNumbersWithComma);
    }

    public static void printLottoResult(WinningStatistics winningStatistics, double earningsRate) {
        System.out.println(LINE_SEPARATOR + "당첨 통계");
        System.out.println("---------");

        for (WinningRank rank : WinningRank.validRanks()) {
            printWinningRankInfo(winningStatistics, rank);
        }
        printEarningsRateAndProfitLossStatus(earningsRate);
    }

    private static void printWinningRankInfo(WinningStatistics winningStatistics, WinningRank rank) {
        int count = winningStatistics.getCount(rank);
        int prize = rank.getMoneyOfPrize();
        String bonusBallMessage = rank == WinningRank.SECOND ? ", 보너스 볼 일치" : "";
        System.out.printf("%d개 일치%s (%d원)- %d개%n", rank.getCountOfMatch(), bonusBallMessage, prize, count);
    }

    private static void printEarningsRateAndProfitLossStatus(double earningsRate) {
        System.out.printf("총 수익률은 %.2f입니다.", earningsRate);
        if (earningsRate < MINIMUM_EARNINGS_RATE_FOR_PROFIT) {
            System.out.printf("(기준이%s이기 때문에 결과적으로 손해라는 의미임)", MINIMUM_EARNINGS_RATE_FOR_PROFIT);
        }
    }
}
