package lotto.model;

import static lotto.model.Profit.LOTTO_PRICE;

public class Price {
    private final int price;

    public Price(int price) {
        validation(price);
        this.price = price;
    }

    public Price() {
        this(3000);
    }

    private void validation(int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException("구매금액은 최소 1000원이상입니다");
        }

        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구매금액은 1000원 단위입니다");
        }
    }

    public void manualValidation(int manualQuantity) {
        if (manualQuantity < 0) {
            throw new IllegalArgumentException("입력 개수를 확인해주세요");
        }
        if (manualQuantity * LOTTO_PRICE > this.price) {
            throw new IllegalArgumentException("구매금액을 초과했습니다");
        }
    }

    public int restPrice(int manualQuantity) {
        return this.price - manualQuantity * LOTTO_PRICE;
    }

    public int totalQuantity() {
        return this.price / LOTTO_PRICE;
    }
}
