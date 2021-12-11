package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class PurchaseLottosRequest {
    private final int purchasingAmount;

    private PurchaseLottosRequest(int purchasingPrice) {
        validatePurchasePrice(purchasingPrice);
        this.purchasingAmount = purchasingPrice;
    }

    public static PurchaseLottosRequest from(int purchasingPrice) {
        return new PurchaseLottosRequest(purchasingPrice);
    }

    public int purchasingLottoSize() {
        return purchasingAmount / Lotto.PRICE;
    }

    private void validatePurchasePrice(int purchasePrice) {
        if (lessThanMinPrice(purchasePrice)) {
            throw new IllegalArgumentException(Lottos.MIN_LOTTO_PRICE + "원 이상의 가격이 전달되어야합니다.");
        }
        if (isInvalidPrice(purchasePrice)) {
            throw new IllegalArgumentException(String.format("로또구입금액(%,d)은 %,d의 배수이어야합니다.", purchasePrice, Lotto.PRICE));
        }
    }

    private boolean lessThanMinPrice(int purchasePrice) {
        return purchasePrice < Lottos.MIN_LOTTO_PRICE;
    }

    private boolean isInvalidPrice(int purchasePrice) {
        return purchasePrice % Lotto.PRICE != 0;
    }
}
