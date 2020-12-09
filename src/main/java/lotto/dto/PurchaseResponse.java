package lotto.dto;

import lotto.domain.LottoTickets;

public class PurchaseResponse {

    private final LottoTickets lottoTickets;

    private PurchaseResponse(final LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static PurchaseResponse of(final LottoTickets lottoTickets) {
        return new PurchaseResponse(lottoTickets);
    }
}
