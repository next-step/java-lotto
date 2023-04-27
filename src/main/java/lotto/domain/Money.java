package lotto.domain;

public class Money {

    private static final Integer LOTTO_UNIT_PRICE = 1_000;

    private final Integer price;

    private Money(Integer price) {
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

    public boolean isOverTotalQuantity(Integer amount) {
        return amount > getLottoQuantity();
    }

    public Integer getAutoLottoAmount(Integer amount) {
        return getLottoQuantity() - amount;
    }
}
