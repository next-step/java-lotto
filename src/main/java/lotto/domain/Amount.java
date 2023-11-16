package lotto.domain;

public class Amount {

    private static final int LOTTO_AMOUNT = 1000;
    private final int price;

    public Amount(int amount) {
        this.price = amount;
    }

    public int price() {
        return price;
    }

    public int lottoCount() {
        return price / LOTTO_AMOUNT;
    }
}
