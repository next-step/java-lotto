package lotto.domain;

public class LottoConstraint {
    private int countOfNumber;
    private int range;

    public LottoConstraint(int countOfNumber, int range) {
        this.countOfNumber = countOfNumber;
        this.range = range;
    }

    public int getCountOfNumber() {
        return countOfNumber;
    }

    public void setCountOfNumber(int countOfNumber) {
        this.countOfNumber = countOfNumber;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
