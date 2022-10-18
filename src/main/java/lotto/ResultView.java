package lotto;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    public static void printLottoTickets(Lotto lotto) {
        System.out.println(lotto.getTickets().size() + "개를 구매했습니다.");
        for (LottoTicket ticket: lotto.getTickets()) {
            System.out.println(ticket.toNumbersString());
        }
        System.out.println();
    }

    public static void printWinningStatistics(Lotto lotto) {
        System.out.println("\n당첨 통계 \n---------");
        Map<LottoRank, Long> winningStat = lotto.getWinningStat();
        List<LottoRank> sortedLottoRank = winningStat.keySet().stream()
            .filter(LottoRank::isNotNone)
            .sorted(Comparator.comparing(LottoRank::getDisplayOrder)).collect(Collectors.toList());

        for (LottoRank rank : sortedLottoRank) {
            System.out.printf("%d개 일치 (%d원)- %d개 \n", rank.getMatchCount(), rank.getPrize(), winningStat.get(rank));
        }

        printReturnRate(lotto);
    }

    private static void printReturnRate(Lotto lotto) {
        BigDecimal returnRate = lotto.getReturnRate();
        System.out.printf("총 수익률은 %.2f입니다.", returnRate);

        if (returnRate.compareTo(BigDecimal.ONE) < 0) {
            System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
