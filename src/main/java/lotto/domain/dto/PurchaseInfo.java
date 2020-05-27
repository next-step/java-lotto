package lotto.domain.dto;

import lotto.domain.price.Price;
import lotto.domain.ticket.LottoTickets;
import lotto.exception.ErrorMessage;

public class PurchaseInfo {

    private Price price;
    private LottoTickets manualTickets;

    private PurchaseInfo(final Price price, final LottoTickets manualTickets) {
        validatePrice(price);

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
}
