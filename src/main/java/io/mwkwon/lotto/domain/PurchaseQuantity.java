package io.mwkwon.lotto.domain;

import io.mwkwon.lotto.constant.LottoConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PurchaseQuantity {
    private static final String GREATER_THAN_QUANTITY_ERROR_MESSAGE = "입력한 구매금액보다 큰 수량을 입력할 수 없습니다.";
    private static final String NEGATIVE_NUMBER_ERROR_MESSAGE = "0보다 작은 값은 입력할 수 없습니다.";
    private final int quantity;

    private PurchaseQuantity(int quantity) {
        checkNegativeNumber(quantity);
        this.quantity = quantity;
    }

    private void checkNegativeNumber(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR_MESSAGE);
        }
    }

    public static PurchaseQuantity create(int quantity) {
        return new PurchaseQuantity(quantity);
    }

    public void checkValidPossiblePurchaseQuantity(LottoPayment lottoPayment) {
        if (lottoPayment.isGreaterThan(quantity * LottoConstants.LOTTO_PRICE)) {
            throw new IllegalArgumentException(GREATER_THAN_QUANTITY_ERROR_MESSAGE);
        }
    }

    public int calcAutoLottoPurchaseQuantity(LottoPayment lottoPayment) {
        return lottoPayment.calcLottoBuyQuantity() - quantity;
    }

    public boolean isSame(int other) {
        return quantity == other;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseQuantity that = (PurchaseQuantity) o;
        return quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }
}
