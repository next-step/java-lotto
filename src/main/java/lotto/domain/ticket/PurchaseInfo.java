package lotto.domain.ticket;

import lotto.exception.ErrorMessage;

public class PurchaseInfo {

    private final LottoTickets manualTickets;
    private final LottoTickets autoTickets;

    private PurchaseInfo(final LottoTickets manualTickets, final LottoTickets autoTickets) {
        validate(manualTickets, autoTickets);

        this.manualTickets = manualTickets;
        this.autoTickets = autoTickets;
    }

    public static PurchaseInfo valueOf(final LottoTickets manualTickets, final LottoTickets autoTickets) {
        return new PurchaseInfo(manualTickets, autoTickets);
    }

    private void validate(final LottoTickets manualTickets, final LottoTickets autoTickets) {
        if (manualTickets == null || autoTickets == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE);
        }
    }

    public int getManualTicketsCount() {
        return manualTickets.count();
    }

    public int getAutoTicketsCount() {
        return autoTickets.count();
    }

    public LottoTickets getAllTickets() {
        return manualTickets.merged(autoTickets);
    }
}
