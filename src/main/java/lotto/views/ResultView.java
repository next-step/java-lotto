package lotto.views;

import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTicket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void print(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");

        for (final LottoTicket lottoTicket : lottoTickets) {
            System.out.println(prettyString(lottoTicket));
        }
        System.out.println();
    }

    private static String prettyString(LottoTicket lottoTicket) {
        return "[" +
                lottoTicket.lottoNumbers().lottoNumbers()
                        .stream()
                        .mapToInt(LottoNumber::lottoNumber)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(", ")) +
                "]";
    }

    public static void print(LottoStatistics lottoStatistics, int payment) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        printLottoRanksStatistics(lottoStatistics);
        System.out.printf("총 수익률은 %.2f입니다.\n", lottoStatistics.yield(payment));
    }


    private static void printLottoRanksStatistics(LottoStatistics lottoStatistics) {
        final List<LottoRank> lottoRanks = Arrays.asList(LottoRank.values());
        Collections.reverse(lottoRanks);

        lottoRanks.stream()
                .filter(e -> e != LottoRank.MISS)
                .forEach(e -> printLottoRankStatistics(lottoStatistics, e));
    }

    private static void printLottoRankStatistics(LottoStatistics lottoStatistics, LottoRank lottoRank) {
        System.out.printf(
                "%d개 일치 (%d원) - %d개\n",
                lottoRank.matchingCount(), lottoRank.winningPrize(), lottoStatistics.lottoTicketsCount(lottoRank)
        );
    }
}
