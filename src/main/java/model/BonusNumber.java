package model;

public class BonusNumber {

    private static final int MIN_BONUS_NUMBER = 1;
    private static final int MAX_BONUS_NUMBER = 45;

    private final int value;

    public BonusNumber(final int value) {
        validate(value);
        this.value = value;
    }

    private void validate(final int value) {
        if (value < MIN_BONUS_NUMBER || value > MAX_BONUS_NUMBER) {
            throw new IllegalArgumentException("보너스 볼의 범위는 1에서 45 사이의 숫자여야 합니다.");
        }
    }
}
