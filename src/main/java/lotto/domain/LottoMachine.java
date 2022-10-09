package lotto.domain;

import lotto.domain.exception.InvalidLottoPurchasePriceException;

public interface LottoMachine {

    TicketBox issueTickets(PurchasePrice purchasePrice);

    int getLottoPrice();

    default int getTicketCount(PurchasePrice purchasePrice) {
        validatePurchasePrice(purchasePrice);
        return purchasePrice.getPrice() / getLottoPrice();
    }

    private void validatePurchasePrice(PurchasePrice purchasePrice) {
        if (purchasePrice.getPrice() < getLottoPrice()) {
            throw new InvalidLottoPurchasePriceException();
        }
    }

}
