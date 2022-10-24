package lotto.domain.lottomachine;

import lotto.domain.PurchasePrice;
import lotto.domain.TicketBox;
import lotto.domain.exception.InvalidLottoPurchasePriceException;

public interface LottoMachine {

    TicketBox issueTickets(PurchasePrice purchasePrice);

    default int getTicketCount(PurchasePrice purchasePrice, int ticketPrice) {
        validatePurchasePrice(purchasePrice, ticketPrice);
        return purchasePrice.getPrice() / ticketPrice;
    }

    private void validatePurchasePrice(PurchasePrice purchasePrice, int ticketPrice) {
        if (purchasePrice.getPrice() < ticketPrice) {
            throw new InvalidLottoPurchasePriceException();
        }
    }

}
