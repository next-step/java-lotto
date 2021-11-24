package com.kakao.lotto.ui;

import com.kakao.lotto.domain.LottoNumber;
import com.kakao.lotto.domain.LottoRank;
import com.kakao.lotto.domain.LottoTicket;
import com.kakao.lotto.domain.LottoTickets;
import com.kakao.lotto.supportInfo.PurchaseInfo;
import com.kakao.lotto.supportInfo.RankStatistic;

import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public static void printLottoTicket(LottoTickets lottoTickets, PurchaseInfo purchaseInfo) {
        String printFormat = String.format("\n수동으로 %d장, 자동으로 %d개를 구매했습니다.",
                purchaseInfo.getPickedTicketCount(), purchaseInfo.getRandomTicketCount());
        System.out.println(printFormat);

        lottoTickets.getLottoTickets().stream()
                .map(OutputView::lottoTicketPrintFormat)
                .forEach(System.out::println);
    }

    private static String lottoTicketPrintFormat(LottoTicket lottoTicket) {
        return lottoTicket.getLottoNumbers().stream()
                .map(LottoNumber::getValue)
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(",", "[", "]"));
    }

    public static void printLottoWinStatistic(RankStatistic rankStatistic) {
        System.out.println("\n\n당첨통계");
        System.out.println("\n=========");
        rankStatistic.getRankCount().entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(OutputView::printLottoRankCount);
        System.out.printf("총 수익률은 %.1f 입니다. %n", rankStatistic.getProfit());
    }

    private static void printLottoRankCount(Map.Entry<LottoRank, Integer> rankCountEntity) {
        String printFormat = String.format("%s - %d개", lottoRankToString(rankCountEntity.getKey()), rankCountEntity.getValue());
        System.out.println(printFormat);
    }

    private static String lottoRankToString(LottoRank lottoRank) {
        String formatString = lottoRank == LottoRank.SECOND ? "%d개 일치, 보너스 볼 일치 (%d원)" : "%d개 일치 (%d원)";
        return String.format(formatString, lottoRank.getCorrectRank(), lottoRank.getPrice());
    }

}
