package lotto.domain;

public class UserInput {
    private final static int LOTTO_PRICE = 1000;

    private final int count;

    public UserInput(int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException("입력하신 금액이 부족합니다. (최소 금액:" + LOTTO_PRICE + "원)");
        }
        this.count = price / LOTTO_PRICE;
    }

    public int count() {
        return count;
    }
}
