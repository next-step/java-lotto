package lotto.dto;

import static java.lang.Integer.parseInt;

public class PurchaseMoney {
    private int value;

    public PurchaseMoney(String value) {
        this.value = parseInt(value);
    }

    public PurchaseMoney(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
