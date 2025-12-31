package lotto;

public class BonusNumber {
    private final int value;

    private BonusNumber(int value) {
        validateRange(value);
        this.value = value;
    }

    public static BonusNumber of(int value) {
        return new BonusNumber(value);
    }

    public int value() {
        return value;
    }

    private void validateRange(int value) {
        if (value < 1 || value > 45) {
            throw new IllegalArgumentException("보너스 번호는 1~45 범위여야 한다.");
        }
    }
}
