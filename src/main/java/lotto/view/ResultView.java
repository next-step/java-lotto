package lotto.view;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class ResultView {

    private ResultView() {}

    public static void printLottoTickets(Lotto lotto) {
        System.out.println(lotto.getTickets().size() + "개를 구매했습니다.\n" + lotto);
    }

    public static void printWinningStatistics(Map<LottoRank, Long> winningStat, Lotto lotto) {
        System.out.println("\n당첨 통계 \n---------");
        List<LottoRank> sortedLottoRank = winningStat.keySet().stream()
            .filter(LottoRank::isNotNone)
            .sorted(Comparator.comparing(LottoRank::getDisplayOrder)).collect(Collectors.toList());

        for (LottoRank rank : sortedLottoRank) {
            printRankCount(winningStat, rank);
        }

        printReturnRate(winningStat, lotto);
    }

    private static void printRankCount(Map<LottoRank, Long> winningStat, LottoRank rank) {
        if (rank == LottoRank.SECOND) {
            System.out.printf("%d개 일치, 보너스 볼 일치(%d원)- %d개 \n", rank.getMatchCount(), rank.getPrize(), winningStat.get(rank));
            return;
        }

        System.out.printf("%d개 일치 (%d원)- %d개 \n", rank.getMatchCount(), rank.getPrize(), winningStat.get(rank));
    }

    private static void printReturnRate(Map<LottoRank, Long> winningStat, Lotto lotto) {
        BigDecimal returnRate = lotto.getReturnRate(winningStat);
        System.out.printf("총 수익률은 %.2f입니다.", returnRate);

        if (returnRate.compareTo(BigDecimal.ONE) < 0) {
            System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
