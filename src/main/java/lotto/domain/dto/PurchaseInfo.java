package lotto.domain.dto;

import lotto.domain.price.Price;
import lotto.domain.ticket.LottoTickets;
import lotto.exception.AvailableCountExceedException;
import lotto.exception.ErrorMessage;

public class PurchaseInfo {

    private Price price;
    private LottoTickets manualTickets;

    private PurchaseInfo(final Price price, final LottoTickets manualTickets) {
        validatePrice(price);
        verifyAvailableCount(price, manualTickets.count());

        this.price = price;
        this.manualTickets = manualTickets;
    }

    public static PurchaseInfo valueOf(final Price price, final LottoTickets manualTickets) {
        return new PurchaseInfo(price, manualTickets);
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
}
