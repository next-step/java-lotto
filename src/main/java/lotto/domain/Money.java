package lotto.domain;

public class Money {

    private static final int LOTTO_UNIT_PRICE = 1_000;

    private final int price;

    private Money(int price) {
        if (isNegativeNumberOrZero(price)) {
            throw new IllegalArgumentException("1000원 이상 입력해주세요.");
        }
        this.price = price;
    }

    public static Money from(int price) {
        return new Money(price);
    }

    private static boolean isNegativeNumberOrZero(int price) {
        return price < LOTTO_UNIT_PRICE;
    }

    public int getLottoQuantity() {
        return price / LOTTO_UNIT_PRICE;
    }

    public int getPrice() {
        return price;
    }

    public boolean isOverTotalQuantity(int amount) {
        return amount > getLottoQuantity();
    }

    public int getAutoLottoAmount(int amount) {
        return getLottoQuantity() - amount;
    }
}
