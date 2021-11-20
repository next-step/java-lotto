package com.kakao.lotto.ui;

import com.kakao.lotto.domain.LottoNumber;
import com.kakao.lotto.domain.LottoRank;
import com.kakao.lotto.domain.LottoTicket;
import com.kakao.lotto.domain.WinResult;
import com.kakao.lotto.supportInfo.PurchaseInfo;
import com.kakao.lotto.supportInfo.RankStatistic;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public static void printLottoTicket(List<LottoTicket> lottoTickets) {
        lottoTickets.stream()
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

    public static void printLottoWinStatistic(WinResult winResult, PurchaseInfo purchaseInfo) {
        RankStatistic rankStatistic = winResult.createRankStatistic();
        System.out.printf("총 수익률은 %.1f 입니다. %n", rankStatistic.calculateProfitRate(purchaseInfo));
        rankStatistic.getRankCount().entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(OutputView::printLottoRankCount);
    }

    private static void printLottoRankCount(Map.Entry<LottoRank, Integer> rankCountEntity) {
        String printFormat = String.format("%d개 일치 (%d원)- %d개",
                rankCountEntity.getKey().getCorrectRank(), rankCountEntity.getKey().getPrice(), rankCountEntity.getValue());
        System.out.println(printFormat);
    }

}
