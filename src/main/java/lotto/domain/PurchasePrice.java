package lotto.domain;

import lotto.exception.InvalidInputException;

public class PurchasePrice {

    private static final Integer LOTTO_PRICE = 1000;
    private static final String INVALID_UNIT = LOTTO_PRICE + " 단위의 숫자만 입력할 수 있습니다.";

    private final Integer purchasePrice;

    public PurchasePrice(Integer purchasePrice) {
        this.purchasePrice = validatePurchasePrice(purchasePrice);
    }

    public Integer getAmount() {
        return this.purchasePrice / LOTTO_PRICE;
    }

    public Integer getPurchasePrice() {
        return purchasePrice;
    }

    private Integer validatePurchasePrice(Integer purchasePrice) {
        if (purchasePrice % LOTTO_PRICE != 0) {
            throw new InvalidInputException(INVALID_UNIT);
        }
        return purchasePrice;
    }
}
