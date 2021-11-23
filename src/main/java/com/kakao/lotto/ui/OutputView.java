package com.kakao.lotto.ui;

import com.kakao.lotto.domain.LottoNumber;
import com.kakao.lotto.domain.LottoRank;
import com.kakao.lotto.domain.LottoTicket;
import com.kakao.lotto.domain.LottoTicketCollection;
import com.kakao.lotto.supportInfo.WinResult;

import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public static void printLottoTicket(LottoTicketCollection lottoTickets) {
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

    public static void printLottoWinStatistic(WinResult winResult) {
        System.out.printf("총 수익률은 %.1f 입니다. %n", winResult.getProfit());
        winResult.getRankCount().entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(OutputView::printLottoRankCount);
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
