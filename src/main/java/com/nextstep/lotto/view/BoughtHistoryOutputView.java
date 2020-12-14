package com.nextstep.lotto.view;

import com.nextstep.lotto.domain.LottoNumber;
import com.nextstep.lotto.domain.LottoTicket;
import com.nextstep.lotto.domain.LottoTickets;
import com.nextstep.lotto.domain.Money;

import java.util.stream.Collectors;

public class BoughtHistoryOutputView {
    private static final String LOTTO_TICKET_START = "[";
    private static final String LOTTO_TICKET_END = "]";
    private static final String STATIC_BOUGHT_TICKETS_HEADER = "수동으로 ";
    private static final String STATIC_BOUGHT_TICKETS_FOOTER = "장, ";
    private static final String AUTO_BOUGHT_TICKETS_HEADER = "자동으로 ";
    private static final String AUTO_BOUGHT_TICKETS_FOOTER = "개를 구매했습니다.";
    private static final String LOTTO_NUMBER_SEPARATOR = ", ";
    private static final String LOTTO_TICKET_SEPARATOR = "\n";

    public static String parseLottoTickets(LottoTickets lottoTickets) {
        return lottoTickets.getLottoTickets().stream()
                .map(lottoTicket -> parseLottoTicket(lottoTicket) + LOTTO_TICKET_SEPARATOR)
                .collect(Collectors.joining());
    }

    static String getHowManyLottoTickets(final int numberOfStaticLottoTickets, final Money remainMoney) {
        return STATIC_BOUGHT_TICKETS_HEADER +
                numberOfStaticLottoTickets +
                STATIC_BOUGHT_TICKETS_FOOTER +
                AUTO_BOUGHT_TICKETS_HEADER +
                remainMoney.howManyLottoTickets() +
                AUTO_BOUGHT_TICKETS_FOOTER;
    }

    private static String parseLottoTicket(LottoTicket lottoTicket) {
        String lottoNumbers = lottoTicket.getLottoNumbers().stream()
                .map(LottoNumber::getValue)
                .map(number -> number + LOTTO_NUMBER_SEPARATOR)
                .collect(Collectors.joining());

        return LOTTO_TICKET_START +
                lottoNumbers.substring(0, lottoNumbers.length() - LOTTO_NUMBER_SEPARATOR.length()) +
                LOTTO_TICKET_END;
    }
}
