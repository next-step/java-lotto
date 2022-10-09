package lotto.domain;

public class UserInput {
    private final static int LOTTO_PRICE = 1000;
    private final static int LOTTO_MAX_PRICE = 100000;

    private final int price;
    private final int count;

    public UserInput(final int price) {
        if (price < LOTTO_PRICE || price > LOTTO_MAX_PRICE) {
            throw new IllegalArgumentException("입력하신 금액이 올바르지 않습니다. (최소 금액:" + LOTTO_PRICE + "원, 최대 금액:" + LOTTO_MAX_PRICE + ")");
        }
        this.price = price;
        this.count = price / LOTTO_PRICE;
    }

    public int count() {
        return count;
    }

    public int price() {
        return price;
    }
}
