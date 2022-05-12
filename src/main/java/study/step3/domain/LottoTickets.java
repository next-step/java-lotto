package study.step3.domain;

import java.util.Collections;
import java.util.List;

public class LottoTickets {
    private static final int LOTTO_AMOUNT = 1000;

    private final LottoQuantity lottoQuantity;
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoQuantity = new LottoQuantity(lottoTickets.size() * LOTTO_AMOUNT);
        this.lottoTickets = lottoTickets;
    }

    public int lottoQuantity() {
        return lottoQuantity.quantity();
    }

    public List<LottoTicket> readOnlyLottoTicket() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
