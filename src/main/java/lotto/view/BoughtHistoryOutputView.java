package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Money;

import java.util.stream.Collectors;

public class BoughtHistoryOutputView {
    private static final String LOTTO_TICKET_START = "[";
    private static final String LOTTO_TICKET_END = "]";
    private static final String BOUGHT_TICKETS_FOOTER = "개를 구매했습니다.";
    private static final String LOTTO_NUMBER_SEPARATOR = ", ";
    private static final String LOTTO_TICKET_SEPARATOR = "\n";

    static String getHowManyLottoTickets(Money money) {
        return money.howManyLottoTickets() + BOUGHT_TICKETS_FOOTER;
    }

    public static String parseLottoTickets(LottoTickets lottoTickets) {
        return lottoTickets.getLottoTickets().stream()
                .map(lottoTicket -> parseLottoTicket(lottoTicket) + LOTTO_TICKET_SEPARATOR)
                .collect(Collectors.joining());
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
