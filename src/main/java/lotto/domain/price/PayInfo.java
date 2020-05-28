package lotto.domain.price;

import lotto.domain.ticket.LottoTickets;
import lotto.exception.AvailableCountExceedException;
import lotto.exception.ErrorMessage;

public class PayInfo {

    private Price price;
    private LottoTickets manualTickets;

    private PayInfo(final Price price, final LottoTickets manualTickets) {
        validatePrice(price);
        verifyAvailableCount(price, manualTickets.count());

        this.price = price;
        this.manualTickets = manualTickets;
    }

    public static PayInfo valueOf(final Price price, final LottoTickets manualTickets) {
        return new PayInfo(price, manualTickets);
    }

    private static void validatePrice(final Price price) {
        if (price == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE);
        }
    }

    private static void verifyAvailableCount(final Price price, final int manualTicketCount) {
        if (price.isExceedCount(manualTicketCount)) {
            throw new AvailableCountExceedException();
        }
    }

    public int getManualTicketsCount() {
        return manualTickets.count();
    }

    public int getAutoTicketsCount() {
        return price.getTicketCount() - getManualTicketsCount();
    }

    public LottoTickets getManualTickets() {
        return manualTickets;
    }
}
