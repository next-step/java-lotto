package autolotto.machine;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        this.number = number;
    }

    public int value() {
        return this.number;
    }
}
