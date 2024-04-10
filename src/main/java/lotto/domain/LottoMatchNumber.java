package lotto.domain;

import stringcalculator.Operation;

public enum LottoMatchNumber {
    MATCH3(3, 5000) {int totalPrizeMoney(int count) {return prizeMoney * count;}},
    MATCH4(4, 50000) {int totalPrizeMoney(int count) {return prizeMoney * count;}},
    MATCH5(5, 1500000) {int totalPrizeMoney(int count) {return prizeMoney * count;}},
    MATCH6(6, 2000000000) {int totalPrizeMoney(int count) {return prizeMoney * count;}};

    private final int matchNumber;
    protected final int prizeMoney;
    abstract int totalPrizeMoney(int count);

    LottoMatchNumber(int matchNumber, int prizeMoney) {
        this.matchNumber = matchNumber;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    @Override
    public String toString() {
        return matchNumber + "개 일치 (" + prizeMoney + "원)";
    }
}
