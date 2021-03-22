package lotto.views;

import lotto.domain.LottoNumber;
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
    }

    private static String prettyString(LottoTicket lottoTicket) {
        return "[" +
                lottoTicket.ascendingLottoNumbers()
                        .stream()
                        .mapToInt(LottoNumber::lottoNumber)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(", ")) +
                "]";
    }

    public static void print(LottoStatistics lottoStatistics, int payment) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + lottoStatistics.threeMatchingLottoTicketsCount() + "개");
        System.out.println("4개 일치 (50000원) - " + lottoStatistics.fourMatchingLottoTicketsCount() + "개");
        System.out.println("5개 일치 (1500000원) - " + lottoStatistics.fiveMatchingLottoTicketsCount() + "개");
        System.out.println("6개 일치 (2000000000원) - " + lottoStatistics.sixMatchingLottoTicketsCount() + "개");
        System.out.println("총 수익률은 " + lottoStatistics.yield(payment) + "입니다.");
    }
}
