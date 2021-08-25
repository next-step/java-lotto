package lotto;

public class BonusNumber {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 0;

    public BonusNumber(int bonusNumber) {
        if (bonusNumber < MIN_VALUE || bonusNumber >= MAX_VALUE) {
            throw new IllegalArgumentException("Length must be 6.");
        }
    }
}
