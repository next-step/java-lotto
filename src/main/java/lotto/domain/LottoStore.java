package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final int LOTTO_TICKET_PRICE = LottoTicket.PRICE;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoStore(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public LottoTickets buy(final int price) {
        int currentPrice = price;
        List<LottoTicket> lottoTickets = new ArrayList<>();

        while (isEnoughChange(currentPrice)) {
            lottoTickets.add(new LottoTicket(lottoNumberGenerator.generate()));
            currentPrice -= LOTTO_TICKET_PRICE;
        }

        return new LottoTickets(lottoTickets);
    }

    private boolean isEnoughChange(int currentPrice) {
        return LOTTO_TICKET_PRICE <= currentPrice;
    }
}
