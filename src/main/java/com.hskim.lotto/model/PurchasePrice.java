package com.hskim.lotto.model;

import com.hskim.lotto.exception.LottoExceptionMessage;

import java.util.Objects;

public class PurchasePrice {

    private int purchasePrice;

    public PurchasePrice(String purchasePrice) {
        validateNumeric(purchasePrice);
        validatePrice(purchasePrice);
        this.purchasePrice = Integer.parseInt(purchasePrice);
    }

    private void validateNumeric(String purchasePrice) {
        try {
            Integer.parseInt(purchasePrice);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(LottoExceptionMessage.NON_NUMERICAL_VALUE.getMessage());
        }
    }

    private void validatePrice(String purchasePrice) {
        if (Integer.parseInt(purchasePrice) % LottoTicket.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LottoExceptionMessage.INVALID_PURCHASE_PRICE.getMessage());
        }
    }

    public GameNum getGameNum() {
        return new GameNum(purchasePrice / LottoTicket.LOTTO_PRICE);
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
