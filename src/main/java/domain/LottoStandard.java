package domain;

public enum LottoStandard {
    PRIZE_BEGINNING(3),
    PRIZE_ENDING(7),
    PROFIT_STANDARD(1);

    private final int standardNumber;

    LottoStandard(int standardNumber) {
        this.standardNumber = standardNumber;
    }

    public int getStandardNumber() {
        return standardNumber;
    }
}
