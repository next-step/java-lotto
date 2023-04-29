package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private ResultView() {
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        List<LottoTicket> lottoTicketList = lottoTickets.getLottoTickets();
        for (LottoTicket lottoTicket : lottoTicketList) {
            printLottoTicket(lottoTicket);
        }
    }

    private static void printLottoTicket(LottoTicket lottoTicket) {
        String lottoTicketNumbersWithComma = lottoTicket.getLottoNumbers().stream()
                .map(LottoNumber::findLottoNumber)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        System.out.println("[" + lottoTicketNumbersWithComma + "]");
    }

    public static void printLottoResult(WinningStatistics winningStatistics, double earningsRate) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        for (WinningRank rank : WinningRank.validRanks()) {
            int count = winningStatistics.getCount(rank);
            int prize = rank.getPrizeMoney();
            System.out.println(rank.getMatchCount() + "개 일치 (" + prize + "원)- " + count + "개");
        }

        System.out.printf("총 수익률은 %.2f입니다.", earningsRate);
        if (earningsRate < 1) {
            System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
