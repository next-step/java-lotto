package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.ValidationUtils.MINIMUM_PRICE;

public class LottoTicketStore {
    private final LottoNumbersGenerator lottoNumbersGenerator;

    public LottoTicketStore(LottoNumbersGenerator lottoNumbersGenerator) {
        this.lottoNumbersGenerator = lottoNumbersGenerator;
    }

    public LottoTickets buy(int price) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < price / MINIMUM_PRICE; i++) {
            lottoTickets.add(LottoTicket.of(lottoNumbersGenerator.generate()));
        }
        return LottoTickets.of(lottoTickets);
    }
}
