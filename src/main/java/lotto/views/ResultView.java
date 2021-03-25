package lotto.views;

import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTicket;

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
                lottoTicket.lottoNumbers()
                        .stream()
                        .mapToInt(LottoNumber::lottoNumber)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(", ")) +
                "]";
    }

    public static void print(LottoStatistics lottoStatistics, int payment) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + lottoStatistics.lottoTicketsCount(LottoRank.FIFTH) + "개");
        System.out.println("4개 일치 (50000원) - " + lottoStatistics.lottoTicketsCount(LottoRank.FOURTH) + "개");
        System.out.println("5개 일치 (1500000원) - " + lottoStatistics.lottoTicketsCount(LottoRank.THIRD) + "개");
        System.out.println("6개 일치 (2000000000원) - " + lottoStatistics.lottoTicketsCount(LottoRank.FIRST) + "개");
        System.out.println("총 수익률은 " + String.format("%.2f", lottoStatistics.yield(payment)) + "입니다.");
    }
}
