package lotto.view;

import lotto.domain.LottoTickets;
import lotto.domain.WinnerPrize;

import java.util.Map;

public class ResultView {
    public static void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        lottoTickets.getLottoTicketList().forEach(System.out::println);
        System.out.println();
    }

    public static void printWinningStatistics(Map<WinnerPrize, Integer> winningCounts) {
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + winningCounts.get(WinnerPrize.FIFTH) + "개");
        System.out.println("4개 일치 (50000원) - " + winningCounts.get(WinnerPrize.FOURTH) + "개");
        System.out.println("5개 일치 (1500000원) - " + winningCounts.get(WinnerPrize.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + winningCounts.get(WinnerPrize.SECOND) + "개");
        System.out.println("6개 일치 (2000000000원) - " + winningCounts.get(WinnerPrize.FIRST) + "개");
    }

    public static void printEarningsRate(double earningsRate) {
        System.out.println("총 수익률은 " + earningsRate + "입니다.");
    }

}
