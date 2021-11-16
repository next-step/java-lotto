package com.kakao.lotto.ui;

import com.kakao.lotto.domain.LottoNumber;
import com.kakao.lotto.domain.LottoTicket;

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
}
