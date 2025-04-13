package lotto.view;

import java.util.List;
import lotto.domain.LottoOrder;
import lotto.domain.LottoRank;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTicket;

public class ResultView {

    public static void showPurchaseResult(LottoOrder lottoOrder, List<LottoTicket> tickets) {
        // 수동으로 3장, 자동으로 11개를 구매했습니다.
        System.out.println("수동으로 " + lottoOrder.getManualTicketCount() + "장, 자동으로 " + lottoOrder.getAutoTicketCount() + "장을 구매했습니다.");
        for (LottoTicket ticket : tickets) {
            System.out.println(ticket.toString());
        }
    }

    public static void showStatistics(LottoStatistics statistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        showMatchCounts(statistics);
        System.out.println("총 수익률은 " + statistics.calculateProfitRate() + "입니다.");
    }

    private static void showMatchCounts(LottoStatistics statistics) {
        for (LottoRank rank : LottoRank.RANKING_ORDER) {
            int count = statistics.getCountByRank(rank);
            System.out.println(formatMatchCount(rank, count));
        }
    }

    private static String formatMatchCount(LottoRank rank, int count) {
        String bonusMsg = rank.requiresBonusNumber() ? ", 보너스 볼 일치" : "";
        return String.format("%d개 일치%s (%d원) - %d개", rank.getMatchCount(), bonusMsg, rank.getPrizeMoney(1), count);
    }

}
