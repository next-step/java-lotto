package lotto.domain;

import lotto.exception.InvalidInputException;

public class PurchaseInfo {
    private static final Integer LOTTO_PRICE = 1000;
    private static final String INVALID_UNIT = LOTTO_PRICE + " 단위의 숫자만 입력할 수 있습니다.";

    private final Integer purchasePrice;
    private final Amount amount;

    public PurchaseInfo(Integer purchasePrice, Integer manualAmount) {
        this.purchasePrice = validatePurchasePrice(purchasePrice);
        this.amount = new Amount(getTotalAmount(), manualAmount);
    }

    public Integer getPurchasePrice() {
        return this.purchasePrice;
    }

    public Integer getAutoAmount() {
        return this.amount.getAutoAmount();
    }

    public Integer getManualAmount() {
        return this.amount.getManualAmount();
    }

    private Integer getTotalAmount() {
        return this.purchasePrice / LOTTO_PRICE;
    }

    private Integer validatePurchasePrice(Integer purchasePrice) {
        if (purchasePrice % LOTTO_PRICE != 0) {
            throw new InvalidInputException(INVALID_UNIT);
        }
        return purchasePrice;
    }
}
