package lotto.domain.result;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public boolean isSameNumber(final int number) {
        return this.number == number;
    }
}
