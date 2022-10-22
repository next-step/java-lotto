package lotto.domain;

public class BonusNumber {
    private final int number;

    public BonusNumber(final int number) {
        this.number = number;
    }

    public int value() {
        return number;
    }
}
