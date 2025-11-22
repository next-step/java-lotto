package lotto.domain;

public class MatchCount {

    private int value;

    public MatchCount(int value) {
        this.value = value;
    }

    public void plus() {
        this.value++;
    }

    public boolean isCountNotZero() {
        return this.value != 0;
    }

    public int multiplication(int prizeMoney) {
        return this.value * prizeMoney;
    }

    public int getValue() {
        return value;
    }
}
