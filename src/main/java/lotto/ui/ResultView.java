package lotto.ui;

import lotto.domain.LottoGame;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;

import java.util.Map;

public class ResultView {
    public static void viewLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void viewLottoTickets(LottoGame lottoGame) {
        for (LottoTicket ticket : lottoGame.getTickets().getLottoTickets()) {
            System.out.println("[" + ticket.toString() + "]");
        }
        System.out.println();
    }

    public static void viewWinningStatistics(LottoGame lottoGame) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.MISS) {
                System.out.printf("%d개 일치 (%d원)- %d개%n",
                        rank.getCountOfMatch(), rank.getWinningMoney(), lottoGame.getResults().get(rank));
            }
        }
    }

    public static void viewReturnStatistics(Double returnRate) {
        System.out.printf("총 수익률은 %.2f입니다.%n",
                returnRate, returnRate < 1 ? "손해" : "이익");
    }
}
