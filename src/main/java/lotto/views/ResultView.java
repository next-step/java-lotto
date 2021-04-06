package lotto.views;

import lotto.domain.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static String prettyString(LottoTicket lottoTicket) {
        return "[" +
                lottoTicket.lottoNumbers()
                        .stream()
                        .mapToInt(LottoNumber::lottoNumber)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(", ")) +
                "]";
    }

    public static void print(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");

        for (final LottoTicket lottoTicket : lottoTickets) {
            System.out.println(prettyString(lottoTicket));
        }

        System.out.println();
    }

    public static void print(AllLottoTickets allLottoTickets) {
        System.out.printf("\n수동으로 %d개, 자동으로 %d개를 구매했습니다.\n",
                allLottoTickets.manualLottoTicketsCount(), allLottoTickets.autoLottoTicketsCount()
        );

        for (final LottoTicket lottoTicket : allLottoTickets.allLottoTickets().lottoTickets()) {
            System.out.println(prettyString(lottoTicket));
        }

        System.out.println();
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
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d개 일치", lottoRank.matchingCount()));
        if (lottoRank == LottoRank.SECOND) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(String.format(" (%d원)", lottoRank.winningPrize()));
        sb.append(String.format(" - %d개", lottoStatistics.lottoTicketsCount(lottoRank)));

        System.out.println(sb);
    }
}
