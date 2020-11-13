package lotto.domain;

public class LottoConstraint {
    private final int countOfNumber;
    private final int range;

    public LottoConstraint(int countOfNumber, int range) {
        this.countOfNumber = countOfNumber;
        this.range = range;
    }

    public int getCountOfNumber() {
        return countOfNumber;
    }

    public int getRange() {
        return range;
    }
}
