package lotto.domain;

public class Money {
    private final int LOTTO_PRICE = 1_000;

    public int buyCount(int price) {
        return price / LOTTO_PRICE;
    }
}
