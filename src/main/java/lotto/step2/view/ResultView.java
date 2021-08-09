package lotto.step2.view;

import lotto.step2.domain.Lotto;
import lotto.step2.domain.LottoTicket;
import lotto.step2.domain.WinningRank;

import java.util.Map;

public class ResultView {
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";

    public static void printLottoCount(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException("금액이 부족합니다. 로또 1장의 가격은 1000원 입니다.");
        }

        System.out.printf("%d개를 구매했습니다.%n", price / 1000);
    }

    public static void printLottoTicket(Lotto lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets.getLotto()) {
            System.out.println(lottoTicket);
        }
        System.out.println();
    }

    public static void printWinningStatisticsMessage() {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println("---------");
    }

    public static void printWinningRank(Map<WinningRank, Integer> lottoResult) {
        for (WinningRank winningRank : WinningRank.values()) {
            System.out.printf("%d개 일치 (%d원) - %d%n", winningRank.getMatchCount(), winningRank.getWinnings(), lottoResult.getOrDefault(winningRank,0));
        }
    }

    public static void printStatistics(double statistics) {
        System.out.printf("총 수익률은 %.2f 입니다", statistics);
    }
}
