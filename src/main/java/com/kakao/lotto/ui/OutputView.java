package com.kakao.lotto.ui;

import com.kakao.lotto.domain.LottoNumber;
import com.kakao.lotto.domain.LottoRank;
import com.kakao.lotto.domain.LottoTicket;
import com.kakao.lotto.domain.WinResult;
import com.kakao.lotto.supportInfo.PurchaseInfo;

import java.util.Arrays;
import java.util.List;
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
                .map(Object::toString)
                .collect(Collectors.joining(",", "[", "]"));
    }

    public static void printLottoWinStatistic(WinResult winResult, PurchaseInfo purchaseInfo) {
        System.out.printf("총 수익률은 %.1f 입니다. %n", winResult.calculateProfitRate(purchaseInfo));
        Arrays.stream(LottoRank.values())
                .forEach(lottoRank -> System.out.println(lottoRankCountPrintFormat(lottoRank, winResult)));
    }

    private static String lottoRankCountPrintFormat(LottoRank lottoRank, WinResult winResult) {
        return String.format("%d개 일치 (%d원)- %d개",
                lottoRank.getCorrectRank(), lottoRank.getPrice(), winResult.getLottoRankCount(lottoRank));
    }
}
