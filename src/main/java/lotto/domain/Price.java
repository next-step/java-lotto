package lotto.domain;

public class Price {

    private static final String NOT_PURCHASEABLE_EXCEPTION_MESSAGE = "[ERROR] 1000원 단위로 입력해주세요.";
    private static final int LOTTO_PRICE = 1_000;

    private final int price;

    private Price(int price) {
        this.price = price;
        validatePrice();
    }

    public static Price from(int price) {
        return new Price(price);
    }

    public int getValue() {
        return price;
    }

    private void validatePrice() {
        if (notPurchasable()) {
            throw new IllegalArgumentException(NOT_PURCHASEABLE_EXCEPTION_MESSAGE);
        }
    }

    private boolean notPurchasable () {
        return price < LOTTO_PRICE || price % LOTTO_PRICE != 0;
    }
}
