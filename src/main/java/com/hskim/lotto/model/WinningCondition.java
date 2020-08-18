package com.hskim.lotto.model;

import java.util.Objects;

public class WinningCondition {

    private int matchingNumbers;
    private boolean isMatchBonusBall;

    public WinningCondition(int matchingNumbers, boolean isMatchBonusBall) {
        this.matchingNumbers = matchingNumbers;
        this.isMatchBonusBall = isMatchBonusBall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WinningCondition)) return false;
        WinningCondition that = (WinningCondition) o;
        return matchingNumbers == that.matchingNumbers &&
                isMatchBonusBall == that.isMatchBonusBall;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchingNumbers, isMatchBonusBall);
    }
}
