package lotto.dto;

import lotto.domain.LottoTickets;

public class PurchaseResponse {

    private final LottoTickets lottoTickets;

    private final int autoTicketCount;

    private final int manualTicketCount;

    public PurchaseResponse(final LottoTickets lottoTickets, final int autoTicketCount, final int manualTicketCount) {
        this.lottoTickets = lottoTickets;
        this.autoTicketCount = autoTicketCount;
        this.manualTicketCount = manualTicketCount;
    }

    public static PurchaseResponse of(final LottoTickets lottoTickets, final int manualCount) {
        return new PurchaseResponse(lottoTickets, lottoTickets.count() - manualCount, manualCount);
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

    public int getAutoTicketCount() {
        return autoTicketCount;
    }

    public int getManualTicketCount() {
        return manualTicketCount;
    }
}
