package src.domain;

public class Money {

    private final int value;

    public Money(int value) {
        this.value = value;
    }

    public Lotto buyLotto() {
        int gameCount = value / Lotto.LOTTO_PRICE;

        return Lotto.lotto(gameCount);
    }
}
