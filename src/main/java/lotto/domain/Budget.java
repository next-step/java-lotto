package lotto.domain;

public class Budget {

    private int value;

    public Budget(int budget) {
        this.value = budget;
    }

    public int getValue() {
        return value;
    }

    public int divide(int lottoPrice) {
        return value / lottoPrice;
    }
}
