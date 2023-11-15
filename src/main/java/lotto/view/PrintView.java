package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class PrintView {

    public static void printLottoTickets(Lottos lottos) {
        System.out.println(lottos.getTotalTicketCount() + "개를 구매했습니다.");

        lottos.getLottos().forEach(System.out::println);
    }

    public static void printStatistics(Map<Rank, Long> winningRanks) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        Arrays.stream(Rank.values())
                .filter(Rank::isWinningRank)
                .sorted(Comparator.reverseOrder())
                .forEach(rank -> {
                    long count = winningRanks.getOrDefault(rank, 0L);
                    String printString = rank.getMatchCount() + "개 일치 (" + rank.getWinningPrice() + "원) - " + count;

                    if (rank == Rank.SECOND) {
                        printString = rank.getMatchCount() + "개 일치, 보너스 볼 일치(" + rank.getWinningPrice() + "원) - " + count;
                    }
                    System.out.println(printString);
                });

    }

    public static void printReturnRate(BigDecimal returnRate) {
        if ((returnRate.compareTo(BigDecimal.ONE) < 0)) {
            System.out.println("총 수익률은 " + returnRate + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
