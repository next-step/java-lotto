package lotto.view;

import java.util.Map;
import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class ResultView {

    public static void showPurchaseResult(LottoTickets tickets) {
        // 수동으로 3장, 자동으로 11개를 구매했습니다.
        System.out.println("수동으로 " + tickets.getManualTicketCount() + "장, 자동으로 " + tickets.getAutoTicketCount() + "장을 구매했습니다.");
        for (LottoTicket ticket : tickets.getTickets()) {
            System.out.println(ticket.toString());
        }
    }

    public static void showStatistics(Map<LottoRank, Long> statistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (LottoRank rank : LottoRank.RANKING_ORDER) {
            Long count = statistics.getOrDefault(rank, 0L);
            System.out.println(formatMatchCount(rank, count));
        }
    }

    private static String formatMatchCount(LottoRank rank, Long count) {
        String bonusMsg = rank.requiresBonusNumber() ? ", 보너스 볼 일치" : "";
        return String.format("%d개 일치%s (%d원) - %d개", rank.getMatchCount(), bonusMsg, rank.getPrizeMoney(1), count);
    }


    public static void showProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "입니다.");
    }

}
