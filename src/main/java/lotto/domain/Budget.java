package lotto.domain;

public class Budget {

    private int value;

    public Budget(int budget) {
        this.value = budget;
    }

    public int getValue() {
        return value;
    }

    public int canBuyQuantity() {
        return value / Lotto.LOTTO_PRICE;
    }
}
