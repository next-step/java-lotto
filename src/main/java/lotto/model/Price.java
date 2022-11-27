package lotto.model;


public class Price {
    public static final int LOTTO_PRICE = 1_000;
    private final int price;

    public Price(int price) {
        validation(price);
        this.price = price;
    }

    private void validation(int price) {
        if (0 < price && price < LOTTO_PRICE || price < 0) {
            throw new IllegalArgumentException("구매금액은 최소 1000원이상입니다");
        }

        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구매금액은 1000원 단위입니다");
        }
    }

    public int totalQuantity() {
        return this.price / LOTTO_PRICE;
    }

    public int autoQuantity(int manualQuantity) {
        return (this.price - manualQuantity * LOTTO_PRICE) / LOTTO_PRICE;
    }

    void totalMoneyValidation(int manualQuantity) {
        if (manualQuantity * LOTTO_PRICE > price) {
            throw new IllegalArgumentException("구매금액을 초과했습니다");
        }
    }
}
