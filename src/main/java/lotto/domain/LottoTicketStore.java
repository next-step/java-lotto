package lotto.domain;

import java.util.ArrayList;
import java.util.List;


public class LottoTicketStore {
    private static final int MINIMUM_PRICE = 1000;
    public static final String TICKET_PRICE_ERROR_MESSAGE = "티켓값은 최소 1000원 이상이어야 합니다.";

    private final LottoNumbersGenerator lottoNumbersGenerator;

    public LottoTicketStore(LottoNumbersGenerator lottoNumbersGenerator) {
        this.lottoNumbersGenerator = lottoNumbersGenerator;
    }

    public LottoTickets buy(int price) {
        validatePrice(price);
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < price / MINIMUM_PRICE; i++) {
            lottoTickets.add(LottoTicket.of(lottoNumbersGenerator.generate()));
        }
        return new LottoTickets(lottoTickets);
    }

    private void validatePrice(int price) {
        if (price < MINIMUM_PRICE) {
            throw new IllegalArgumentException(TICKET_PRICE_ERROR_MESSAGE);
        }
    }
}
