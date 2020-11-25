package domain;

public enum LottoStandard {
    MATCH_BEGINNING(1),
    MATCH_ENDING(6),
    PROFIT_STANDARD(1);

    private final int standardNumber;

    LottoStandard(int standardNumber) {
        this.standardNumber = standardNumber;
    }

    public int getStandardNumber() {
        return standardNumber;
    }
}
