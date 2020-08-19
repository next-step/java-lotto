package com.hskim.lotto.model;

import com.hskim.lotto.exception.LottoTicketingExceptionMessage;

import java.util.Objects;

public class PurchasePrice {

    private int purchasePrice;

    public PurchasePrice(int purchasePrice) {
        validatePrice(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    private void validatePrice(int purchasePrice) {
        if (purchasePrice % LottoTicket.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LottoTicketingExceptionMessage.INVALID_PURCHASE_PRICE.getMessage());
        }
    }

    public GameNumber getGameNum() {
        return new GameNumber(purchasePrice / LottoTicket.LOTTO_PRICE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchasePrice)) return false;
        PurchasePrice that = (PurchasePrice) o;
        return purchasePrice == that.purchasePrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchasePrice);
    }
}
